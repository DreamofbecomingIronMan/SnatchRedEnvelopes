package com.zhongtongnev.modules.dingtalk.service;


import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.open.client.api.model.corp.JsapiTicket;
import com.dingtalk.open.client.api.service.corp.JsapiService;
import com.dingtalk.open.client.common.ServiceException;
import com.zhongtongnev.common.utils.Global;
import com.zhongtongnev.common.utils.SpringContextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 */
@Service
@Transactional(readOnly = true)
public class DDTalkCoreService {
    private static final int expiresIn = 6000 * 1000;  //6000秒，为避免网络延迟，降低一下
    private JsapiService jsapiService;

    private Long jsapiTicketExp;
    private String jsapiTicketStr;

    private Long accessTokenExp;
    private String accessTokenStr;

    public synchronized String jsapiTicket() {
        if (isJsapiTicketExpired()) {
            return jsapiTicketStr;
        }
        try {
            String token = accessToken();
            JsapiTicket jsapiTicket = getJsapiService().getJsapiTicket(token, "jsapi");
            long timeStamp = System.currentTimeMillis();
            jsapiTicketExp = timeStamp + expiresIn;
            jsapiTicketStr = jsapiTicket.getTicket();
            return jsapiTicketStr;
        } catch (ServiceException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public String sign(String ticket, String nonceStr, long timeStamp, String url) {

        String plain = "jsapi_ticket=" + ticket + "&noncestr=" + nonceStr + "&timestamp=" + String.valueOf(timeStamp)
                + "&url=" + url;
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            sha1.reset();
            sha1.update(plain.getBytes("UTF-8"));
            return bytesToHex(sha1.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    //将bytes类型的数据转化为16进制类型
    private static String bytesToHex(byte[] hash) {                    //将字符串转化为16进制的数据
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;

    }

    public synchronized String accessToken() {
        if (isAccessTokenExpired()) {
            return accessTokenStr;
        }
        try {
            DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
            OapiGettokenRequest request = new OapiGettokenRequest();
            request.setAppkey(Global.getConfig("Appkey"));
            request.setAppsecret(Global.getConfig("AppSecret"));
            request.setHttpMethod("GET");
            OapiGettokenResponse response = client.execute(request);
            long timeStamp = System.currentTimeMillis();
            accessTokenExp = timeStamp + expiresIn;
            accessTokenStr = response.getAccessToken();
            return accessTokenStr;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public boolean isAccessTokenExpired() {
        Long accessTokenExpiredTime = accessTokenExp;
        long timeStamp = System.currentTimeMillis();

        return accessTokenExpiredTime == null ? false : (long) accessTokenExpiredTime >= timeStamp;
    }

    private JsapiService getJsapiService() {
        if (jsapiService == null) {
            jsapiService = SpringContextUtils.getBean(JsapiService.class);
        }
        return jsapiService;
    }

    public boolean isJsapiTicketExpired() {
        Long jsapiTicketExpiredTime = jsapiTicketExp;
        long timeStamp = System.currentTimeMillis();

        return jsapiTicketExpiredTime == null ? false : (long) jsapiTicketExpiredTime >= timeStamp;
    }
}
