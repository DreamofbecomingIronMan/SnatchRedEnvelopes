package com.zhongtongnev.modules.dingtalk.api;


import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.zhongtongnev.common.utils.Result;
import com.zhongtongnev.modules.app.utils.JwtUtils;
import com.zhongtongnev.modules.dingtalk.service.TestDDTalkCoreService;
import com.zhongtongnev.modules.sys.entity.SysUserEntity;
import com.zhongtongnev.modules.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 免登服务
 */
@Api("钉钉接口")
@RestController
@RequestMapping("/ddtalk/api/miandeng")
public class DDTalkController {

    @Autowired
    private TestDDTalkCoreService ddTalkService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private JwtUtils jwtUtils;

    @ApiOperation("h5config")
    @GetMapping("h5config")
    public Result config(HttpServletRequest request) {
        String url = request.getParameter("purl");
        if (StringUtils.isNotBlank(url)) {
            try {
                url = URLDecoder.decode(url, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            return Result.error("URL不能为空");
        }

        String corpId = ddTalkService.getCorpId();
        String agentId = ddTalkService.getAgentId();
        String nonceStr = ddTalkService.getNonceStr();

        long timeStamp = System.currentTimeMillis() / 1000;     //时间戳参数
        //请求链接的参数，这个链接主要用来生成signatrue，并不需要传到前端

//        String accessToken = ddTalkService.accessToken();   //token参数
        String jsticket = ddTalkService.jsapiTicket();  //ticket参数
        String signature = ddTalkService.sign(jsticket, nonceStr, timeStamp, url);  //签名参数

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("jsticket", jsticket);
        resultMap.put("signature", signature);
        resultMap.put("nonceStr", nonceStr);
        resultMap.put("timeStamp", timeStamp);
        resultMap.put("corpId", corpId);
        resultMap.put("agentId", agentId);

        return Result.ok().addData(resultMap);
    }

    @ApiOperation("获取钉钉UserId")
    @GetMapping("userid")
    public Object userid(HttpServletRequest request) {
        String code = request.getParameter("code");
        CorpUserDetail userinfo = ddTalkService.getUserinfo(code);
        if(userinfo != null){
            String userid = userinfo.getUserid();
            SysUserEntity userEntity = sysUserService.getByDdUserId(userid);
            if (userEntity != null){
                String token = jwtUtils.generateToken(userEntity.getUserId());
                return Result.ok().addData(token);
            }
        }
        return Result.error("用户信息获取失败");
    }

}
