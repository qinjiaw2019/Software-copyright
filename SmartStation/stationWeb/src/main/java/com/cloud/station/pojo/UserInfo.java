package com.cloud.station.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

//用户信息实体
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {
	
	//主键
	private Long id;
	
	//账号
	private String account;
	
	//手机号
	private String tel;
	
	//注册时间,以时间戳的形式保存
	private Long createTime;
	
	//账号余额，保留2位小数
	private float money;
	
	//头像，图片路径
	private String face;
	
	//等级积分,跟消费积分是分开的
	private float rankPoints;
	
	//身份证号码
	private String idCard;
	
	//信誉度,保留一位小数
	private float reputationPoints;
	
	//密码，加密处理
	private String pwd;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public float getRankPoints() {
		return rankPoints;
	}
	public void setRankPoints(float rankPoints) {
		this.rankPoints = rankPoints;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public float getReputationPoints() {
		return reputationPoints;
	}
	public void setReputationPoints(float reputationPoints) {
		this.reputationPoints = reputationPoints;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	@Override
	public String toString() {
		return "UserInfo{" +
				"id=" + id +
				", account='" + account + '\'' +
				", tel='" + tel + '\'' +
				", createTime=" + createTime +
				", money=" + money +
				", face='" + face + '\'' +
				", rankPoints=" + rankPoints +
				", idCard='" + idCard + '\'' +
				", reputationPoints=" + reputationPoints +
				", pwd='" + pwd + '\'' +
				'}';
	}
}
