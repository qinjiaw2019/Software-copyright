package com.cloud.station.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

//车位占用记录类
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogStation {
	//主键
	private Long id;
	
	//车位编号
	private Long stationCode;
	
	//停车场名称
	private Long depoteName;
	
	//用户id
	private Long userId;
	
	//创建时间
	private Long createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStationCode() {
		return stationCode;
	}

	public void setStationCode(Long stationCode) {
		this.stationCode = stationCode;
	}

	public Long getDepoteName() {
		return depoteName;
	}

	public void setDepoteName(Long depoteName) {
		this.depoteName = depoteName;
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
	
}
