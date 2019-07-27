package com.zhongtongnev.common.utils;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Properties;

/**
 * 全局配置类
 *
 * @author GordonYang
 * @version 1.0
 * @since 2013-4-16 上午10:36:24
 */
//@DependsOn("springContextUtils")
public class Global {

    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = Maps.newHashMap();

    /**
     * 属性文件加载对象
     */
    private static PropertiesLoader propertiesLoader = new PropertiesLoader("ddconfig.properties");

    /**
     * 获取配置
     */
    public static String getConfig(String key) {
        String value = map.get(key);
        if (value == null) {
            value = propertiesLoader.getProperty(key);
            map.put(key, value);
        }
        return value;
    }

    public static boolean getConfigBoolean(String key) {
        try {
            String value = getConfig(key);
            boolean bRnt = Boolean.valueOf(value);
            return bRnt;
        } catch (Exception e) {
            return false;
        }
    }

    public static Properties getAll() {
        return propertiesLoader.getProperties();
    }
}
