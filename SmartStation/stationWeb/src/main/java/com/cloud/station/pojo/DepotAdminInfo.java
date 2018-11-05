package com.cloud.station.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

//停车场管理员类
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepotAdminInfo {
	//主键
	private Long id;
	
	//停车场管理员帐号
	private String account;
	
	//密码，加密处理
	private String pwd;
	
	//创建时间
	private Long createTime;

		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	
}
