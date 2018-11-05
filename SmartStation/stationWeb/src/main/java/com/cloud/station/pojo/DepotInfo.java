package com.cloud.station.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

//停车场信息类
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepotInfo {
	//主键
	private Long id;
	
	//停车场名称
	private String name;
	
	//停车场地址外键ID号
	private Long addressId;
	
	//信息创建者ID号
	private Long userId;
	
	//创建时间，时间戳形式
	private Long createTime;
	
	//描述信息
	private String desc;
	
	//车位总数
	private int stationNum;

	private String address;

	//纬度
	private Double latitude;

	//经度
	private Double longitude;

	private DepotStationState depotStationState;

	private String photo;//照片

	private Double distance;//与中心点的直线距离
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getStationNum() {
		return stationNum;
	}
	public void setStationNum(int stationNum) {
		this.stationNum = stationNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public DepotStationState getDepotStationState() {
		return depotStationState;
	}

	public void setDepotStationState(DepotStationState depotStationState) {
		this.depotStationState = depotStationState;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "DepotInfo{" +
				"id=" + id +
				", name='" + name + '\'' +
				", addressId=" + addressId +
				", userId=" + userId +
				", createTime=" + createTime +
				", desc='" + desc + '\'' +
				", stationNum=" + stationNum +
				", address='" + address + '\'' +
				", latitude=" + latitude +
				", longitude=" + longitude +
				", depotStationState=" + depotStationState +
				", photo='" + photo + '\'' +
				'}';
	}
}
