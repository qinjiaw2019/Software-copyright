package com.cloud.station.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

//紧急联系人类
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserUrgentContact {
	//主键
	private Long id;
	
	//联系人姓名
	private Long realName;
	
	//联系人电话
	private Long contactTel;
	
	//可用状态，0为不可用，1为可用
	private Long telStatus;
	
	//权值：用于排序，权值降序排列
	private Long weight;
	
	//描述
	private Long desc;
	
	//创建者id
	private Long userId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRealName() {
		return realName;
	}
	public void setRealName(Long realName) {
		this.realName = realName;
	}
	public Long getContactTel() {
		return contactTel;
	}
	public void setContactTel(Long contactTel) {
		this.contactTel = contactTel;
	}
	public Long getTelStatus() {
		return telStatus;
	}
	public void setTelStatus(Long telStatus) {
		this.telStatus = telStatus;
	}
	public Long getWeight() {
		return weight;
	}
	public void setWeight(Long weight) {
		this.weight = weight;
	}
	public Long getDesc() {
		return desc;
	}
	public void setDesc(Long desc) {
		this.desc = desc;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
