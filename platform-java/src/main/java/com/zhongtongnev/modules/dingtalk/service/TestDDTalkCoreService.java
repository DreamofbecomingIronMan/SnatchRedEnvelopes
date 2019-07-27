package com.zhongtongnev.modules.dingtalk.service;

import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.dingtalk.open.client.api.service.corp.CorpUserService;
import com.zhongtongnev.common.utils.Global;
import com.zhongtongnev.common.utils.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDDTalkCoreService {

    @Autowired
    private DDTalkCoreService ddTalkCoreService;

    private CorpUserService corpUserService;

    public String getCorpId() {
        return Global.getConfig("CorpId");
    }

    public String getAgentId() {
        return Global.getConfig("AgentId");
    }

    public String getNonceStr() {
        return Global.getConfig("NonceStr");
    }

    public String jsapiTicket() {
        return ddTalkCoreService.jsapiTicket();
    }

    public String sign(String ticket, String nonceStr, long timeStamp, String url) {
        return ddTalkCoreService.sign(ticket, nonceStr, timeStamp, url);
    }

    public CorpUserDetail getUserinfo(String code) {
        try {
            String accessToken = ddTalkCoreService.accessToken();

            CorpUserDetail detail = getCorpUserService().getUserinfo(accessToken, code);
            return detail;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private CorpUserService getCorpUserService() {
        if (corpUserService == null) {
            corpUserService = SpringContextUtils.getBean(CorpUserService.class);
        }
        return corpUserService;
    }
}