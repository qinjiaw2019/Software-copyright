package com.cloud.station.service;

import java.util.List;




import com.cloud.station.base.BaseService;
import com.cloud.station.pojo.UserInfo;

/**
 * @className:     UserInfoService
 * @data:          2018-03-07
 * @lastModify:    2018-03-07
 * @description:   用户基本信息 service接口
 */
public interface UserInfoService extends BaseService {
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
	public UserInfo getUserInfoByAccount(String account);
	
	/**
     * 增加一条记录
     * @param userInfo 实体
     * @return         影响记录条数
     */
    public Integer save(UserInfo userInfo);

}
