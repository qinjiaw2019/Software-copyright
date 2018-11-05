package com.cloud.station.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

//车位状态信息类
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepotStationState implements Serializable {
	//主键
	private Long id;
	
	//停车场ID号
	private Long stationId;

	//状态，0为空闲,1为占用，2为VIP车位，3暂停使
	private int state;
	
	//占用开始时间
	private Long startTime;
	
	//占用释放时间
	private Long endTime;
	
	//用户ID
	private Long userId;

	private int left;//剩余数量

	private String carNumber;//车牌号码

	private DepotInfo depotInfo;//停车场信息

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStationId() {
		return stationId;
	}

	public void setStationId(Long stationId) {
		this.stationId = stationId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public DepotInfo getDepotInfo() {
		return depotInfo;
	}

	public void setDepotInfo(DepotInfo depotInfo) {
		this.depotInfo = depotInfo;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	@Override
	public String toString() {
		return "DepotStationState{" +
				"id=" + id +
				", stationId=" + stationId +
				", state=" + state +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", userId=" + userId +
				", left=" + left +
				", carNumber='" + carNumber + '\'' +
				", depotInfo=" + depotInfo +
				'}';
	}
}
