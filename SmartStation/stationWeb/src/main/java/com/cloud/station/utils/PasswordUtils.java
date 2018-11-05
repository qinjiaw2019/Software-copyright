package com.cloud.station.utils;

/**
 * 密码处理工具类
 */
public class PasswordUtils {

    /**
     * 密码加密处理
     * @param password
     * @return
     */
    public static String encrpty(String password){
        //TODO PasswordUtils.encrpty 未实现
        return password;
    }

    /**
     * 匹配密码是否正确
     * @param oldPassword 原密码
     * @param newPassword 加密后的密码
     * @return
     */
    public static boolean check(String oldPassword,String newPassword){
        return newPassword.equals(encrpty(oldPassword));
    }

    /**
     * 字符过滤
     * @param password 原始密码
     * @return
     */
    public static String filer(String password){
    	//TODO 字符密码过滤,未实现
        return password;
    }
    
    /**
     * 判断密码长度
     * @param password
     * @return
     */
    public static boolean checkLength(String password){
    	//TODO 判断密码长度,未实现
    	return true;
    }
}
