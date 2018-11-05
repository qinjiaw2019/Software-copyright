package com.middleware.pojo;

public class DeliverHistory {
	
	private Integer id;//ID
	
	private Integer deliver_id;//包裹ID
	
	private String address;//到达地址
	
	private Integer reciver_id;//处理人ID
	
	private Long create_time;//处理时间
	
	private AdminUser adminUser;//处理人详细信息

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDeliver_id() {
		return deliver_id;
	}

	public void setDeliver_id(Integer deliver_id) {
		this.deliver_id = deliver_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getReciver_id() {
		return reciver_id;
	}

	public void setReciver_id(Integer reciver_id) {
		this.reciver_id = reciver_id;
	}

	public Long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Long create_time) {
		this.create_time = create_time;
	}

	public AdminUser getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(AdminUser adminUser) {
		this.adminUser = adminUser;
	}
	
	
}
