package com.cloud.station.utils.result;


import com.cloud.station.constant.Code;
import com.cloud.station.constant.HttpCode;

/**
 * JSON返回数据工具类
 */
public class JSONReturn {
    /**
	 * success
	 * @param errcode 错误码
	 * @param object 数据
	 * @param msg 消息
	 * @return
	 */
	public static JSONType success(Object object,Integer errcode,String msg) {
		return new JSONType(errcode,msg,object);
	}

	/**
	 * 成功返回
	 * @param object 数据
	 * @return
	 */
	public static JSONType success(Object object) {
		return success(object, Code.SUCCESS,null);
	}

	public static JSONType success(Object object,String msg) {
		return success(object,Code.SUCCESS,msg);
	}

	public static JSONType success(){
		return success(null,Code.SUCCESS,null);
	}
	/**
	 * error
	 * @param errcode 错误码
	 * @param object 数据
	 * @param msg 信息
	 * @return
	 */
    public static JSONType error(Object object,Integer errcode,String msg) {
        JSONType jsonType = new JSONType();
		jsonType.setCode(errcode);
		jsonType.setMsg(msg);
		jsonType.setData(object);
        return jsonType;
    }
	public static JSONType error(Integer errcode,String msg) {
    	return error(null,errcode,msg);
	}

	/**
	 * 出错
	 * @param msg 错误信息
	 * @return
	 */
	public static JSONType error(String msg) {
    	return error(null, Code.ERROR,msg);
	}

	/**
	 * 参数缺失
	 * @return
	 */
	public static JSONType missing() {
		return error(null, HttpCode.PARAMETER_MISSING, "parameter missing");
	}

	public static JSONType empty(String msg){
		return success(null,HttpCode.RESULT_EMPTY,msg);
	}
}