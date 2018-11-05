package com.middleware.pojo;

import java.util.List;

public class DeliverEx extends Deliver{
	private User user;//发货人

	private AdminUser adminUser;//揽件人
	
	private Long createTime;//揽件时间
	
	private List history;//物流信息
	
	private Express express;//快递机构详细信息
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AdminUser getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(AdminUser adminUser) {
		this.adminUser = adminUser;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public List getHistory() {
		return history;
	}

	public void setHistory(List history) {
		this.history = history;
	}

	public Express getExpress() {
		return express;
	}

	public void setExpress(Express express) {
		this.express = express;
	}
	
}
