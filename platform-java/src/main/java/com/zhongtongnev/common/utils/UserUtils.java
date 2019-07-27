package com.zhongtongnev.common.utils;

import com.zhongtongnev.common.exception.NevException;
import com.zhongtongnev.modules.app.interceptor.AuthorizationInterceptor;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * token请求方式使用
 */
public class UserUtils {

    private static Logger logger = LoggerFactory.getLogger(UserUtils.class);

    /**
     * 获取当前用户信息，不存在 报异常
     *
     * @return
     */
    public static String getUserName() {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        //获取用户ID
        String userName = (String) request.getAttribute(AuthorizationInterceptor.USER_KEY);
        if (StringUtils.isBlank(userName)) {
            throw new NevException("未获取到当前用户信息:" + request.getRequestURI());
        }
        return userName;
    }

    /**
     * 获取当前用户，可以返回null
     *
     * @return
     */
    public static String checkUserName() {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        //获取用户ID
        String userName = (String) request.getAttribute(AuthorizationInterceptor.USER_KEY);
        return userName;
    }

}
