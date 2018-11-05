package com.cloud.station.utils.result;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * JSON 返回结果集
 * @param <T>
 */
public class JSONType<T> implements Serializable{

	/* 错误码 */
	private Integer code;
	/* 提示信息 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private  String msg ;

	/* 具体的内容 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private T data;

	public JSONType() {
	}

	public JSONType(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}