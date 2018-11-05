package com.middleware.pojo;

public class DeliverRecive {
	
	private Integer deliver_id;//包裹ID
	private Integer reciver_id;//揽件人ID
	private Long create_time;//揽件时间
	public Integer getDeliver_id() {
		return deliver_id;
	}
	public void setDeliver_id(Integer deliver_id) {
		this.deliver_id = deliver_id;
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
	
	
}
