package com.middleware.pojo;

import java.lang.Thread.State;

public class Deliver {

	private Integer id;//ID
	
	private String name;//包裹名称
	
	private Integer userId;//用户ID
	
	private String code;//包裹编号
	
	private Long createTime;//创建时间
	
	private Integer state;//包裹状态(0:发 1:收 2:运输中 3:回退)
	
	private Integer addressId;//地址ID
	
	private Integer expressId;//机构ID

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getExpressId() {
		return expressId;
	}

	public void setExpressId(Integer expressId) {
		this.expressId = expressId;
	}

	
	
}
