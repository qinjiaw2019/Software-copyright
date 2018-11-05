package com.cloud.station.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cloud.station.base.BaseService;
import com.cloud.station.pojo.Address;
import com.cloud.station.pojo.AdminInfo;
import com.cloud.station.pojo.DepotAdminInfo;
import com.cloud.station.pojo.UserInfo;

/**
 * @className:     DepotAdminInfoService
 * @data:          2018-03-07
 * @lastModify:    2018-03-07
 * @description:   停车场管理员service接口
 */
public interface DepotAdminInfoService extends BaseService {
	
	/**
	 * 根据用户名查询密码
	 * @param account
	 * @return
	 */
	public String getPasswordByAccount(String account);
	
	/**
	 * 根据用户名查询用户的基本信息
	 * @param account
	 * @return
	 */
	public DepotAdminInfo getDepotAdminInfoByAccount(String account);
}
