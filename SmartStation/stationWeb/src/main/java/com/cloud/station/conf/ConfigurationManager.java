package com.cloud.station.conf;

import org.springframework.core.io.Resource;

import javax.annotation.Resources;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置管理组件
 */
public class ConfigurationManager {
	private  static final String APP_FILE_NAME = "my.properties";

	private static Properties prop = new Properties();
	
	static {
		try {
			InputStream in = ConfigurationManager.class
					.getClassLoader().getResourceAsStream(APP_FILE_NAME);
			prop.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
	
	/**
	 * 获取整数类型的配置项
	 * @param key
	 * @return
	 */
	public static Integer getInteger(String key) {
		String value = getProperty(key);
		try {
			return Integer.valueOf(value);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static Long getLong(String key) {
		String value = getProperty(key);
		try {
			return Long.valueOf(value);
		} catch (Exception e) {
			return 0L;
		}
	}
	
	/**
	 * 获取Boolean配置项
	 * @param key
	 * @return
	 */
	public static Boolean getBoolean(String key) {
		String value = getProperty(key);
		try {
			return Boolean.valueOf(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
