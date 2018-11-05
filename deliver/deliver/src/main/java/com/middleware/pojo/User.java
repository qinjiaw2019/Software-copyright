package com.middleware.pojo;

public class User {
	private Integer id;//ID
	
	private String username;//用户名
	
	private String password;//密码
	
	private Float money;//余额
	
	private String tell;//电话号码
	
	private Integer integration;//积分
	
	private String name;//姓名

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public Integer getIntegration() {
		return integration;
	}

	public void setIntegration(Integer integration) {
		this.integration = integration;
	}

	
	
	
}
