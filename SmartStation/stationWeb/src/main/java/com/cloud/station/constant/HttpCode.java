package com.cloud.station.constant;

/**
 * RESTFULL状态码
 */
public interface HttpCode {

	public static Integer LOGIN_FAILE = 40010;//登陆失败
	public static Integer LOGIN_PSSWORD_ERROR = 40011;//登陆密码错误
	public static Integer LOGIN_USERNAME_ERROR = 40012;//登陆用户名错误
	public static Integer LOGIN_NULL = 40020;//未登陆
	public static Integer IS_LOGIN = 40022;//已经登陆
	
	public static Integer NOT_EXSITS = 40013;//不存在
	
	public static Integer PARAMETER_MISSING = 40014;//参数缺失
	public static Integer PARAMETER_TYPE_ERROR = 40015;//参数类型错误
	public static Integer PARAMETER_INVALIED = 40016;//参数非法
	public static Integer PARAMETER_EMPTY_VALUE = 40026;//参数为空
	
	public static Integer RESULT_EMPTY = 40017;//结果为空
	
	public static Integer INVALIED_AUTHORITY = 40018;//权限不够
	public static Integer UNEXPETED_ERROR = 40049;//未知错误

	public static Integer RESOURCE_EXSISTS = 40065;//资源存在

	public static Integer RESOURCE_RESET = 40075;//资源被强制重置

}
