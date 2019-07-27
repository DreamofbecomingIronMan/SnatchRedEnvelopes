package com.zhongtongnev.common.validator;

import com.zhongtongnev.common.exception.NevException;
import org.apache.commons.lang.StringUtils;

/**
 * 数据校验
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new NevException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new NevException(message);
        }
    }
}
