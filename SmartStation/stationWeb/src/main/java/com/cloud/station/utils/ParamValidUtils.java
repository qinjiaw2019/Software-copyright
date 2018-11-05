package com.cloud.station.utils;

/**
 * 请求参数验证工具类
 */
public class ParamValidUtils {

    /**
     * 判断字符串是否为空(null或“”)
     * @param param 参数
     * @return 如果为null或者“”返回true，否则返回false
     */
    public static boolean isEmpty(String param){
        return (param==null || param.equals(""));
    }

    public static boolean isNotEmpty(String param){
        return !(param==null || param.equals(""));
    }

    /**
     * 批量判断多个变量是否都为空(null或“”)
     * @param args 参数数组
     * @return 如果为null或者“”返回true，否则返回false
     */
    public static boolean isEmptyAll(String...args){
        for(String arg : args){
            if(isEmpty(arg))
                return true;
        }
        return false;
    }
}
