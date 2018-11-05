package com.cloud.station.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

//车位信息表
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepotStation {
	//主键
	private Long id;
	
	//车位编号
	private String code;
	
	//车位位置
	private String loc;
	
	//车位描述
	private String desc;
	
	//创建时间
	private Long createTime;
	
	//所属停车场ID
	private Long depotId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
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
	public Long getDepotId() {
		return depotId;
	}
	public void setDepotId(Long depotId) {
		this.depotId = depotId;
	}
	
	
}
