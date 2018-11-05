package com.cloud.station.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 类工具
 */
public class BeanUtils {

    /**
     * 通过反射映射类
     * @param request
     * @param clazz
     * @param <T>
     * @return
     */
    public static  <T>T toObject(HttpServletRequest request,Class<T> clazz){
        return PackObject.getObject(request,clazz);
    }
}
