package com.cloud.station.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

//系统管理员类
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminInfo {
	//主键
	private Long id;
	
	//管理员帐号
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
