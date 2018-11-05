package com.cloud.station.pojo;

import java.util.Date;

/*
 *用户黑名单类
 */
public class CarNumberBlacklist {
	//自增主键
	private Long id;
	//车牌号
	private String carNum;
	//使用用户的id
	private Long userId;
	//欠费金额
	private float oweAmount=0.0f;
	//欠费时间(创建时间)
	private Long oweTime=new Date().getTime();
	//处理时间(最近一次)
	private Long disposeTime=0L;
	//欠费次数
	private Long oweMoneyTime=0L;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public float getOweAmount() {
		return oweAmount;
	}
	public void setOweAmount(float oweAmount) {
		this.oweAmount = oweAmount;
	}
	public Long getOweTime() {
		return oweTime;
	}
	public void setOweTime(Long oweTime) {
		this.oweTime = oweTime;
	}
	public Long getDisposeTime() {
		return disposeTime;
	}
	public void setDisposeTime(Long disposeTime) {
		this.disposeTime = disposeTime;
	}
	public Long getOweMoneyTime() {
		return oweMoneyTime;
	}
	public void setOweMoneyTime(Long oweMoneyTime) {
		this.oweMoneyTime = oweMoneyTime;
	}
	
	
}
