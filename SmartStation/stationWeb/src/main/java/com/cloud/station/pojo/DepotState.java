package com.cloud.station.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

//停车场状态信息类
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepotState {

	//主键
	private Long id;
	
	//已占车位数
	private int occupy;
	
	//停车场id
	private Long depotId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getOccupy() {
		return occupy;
	}

	public void setOccupy(int occupy) {
		this.occupy = occupy;
	}

	public Long getDepotId() {
		return depotId;
	}

	public void setDepotId(Long depotId) {
		this.depotId = depotId;
	}
	
	
}
