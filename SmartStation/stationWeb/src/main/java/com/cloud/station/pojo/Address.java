package com.cloud.station.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

//地址信息类
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address implements Serializable{
	//主键
	private Long id;
	
	//省
	private String provice;
	
	//市
	private String city;
	
	//县
	private String country;
	
	//村
	private String village;
	
	//描述
	private String desc;
	
	//创建时间
	private Long createTime;
	
	//停车场管理员ID
	private Long adminDepotId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProvice() {
		return provice;
	}
	public void setProvice(String provice) {
		this.provice = provice;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public Long getAdminDepotId() {
		return adminDepotId;
	}
	public void setAdminDepotId(Long adminDepotId) {
		this.adminDepotId = adminDepotId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address{" +
				"id=" + id +
				", provice='" + provice + '\'' +
				", city='" + city + '\'' +
				", country='" + country + '\'' +
				", village='" + village + '\'' +
				", desc='" + desc + '\'' +
				", createTime=" + createTime +
				", adminDepotId=" + adminDepotId +
				'}';
	}
}
