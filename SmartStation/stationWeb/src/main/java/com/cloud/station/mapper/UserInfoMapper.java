package com.cloud.station.mapper;

import com.cloud.station.base.BaseMapper;
import com.cloud.station.pojo.UserInfo;

/**
 *@className:     UserInfoMapper
 *@data:          2018-03-07
 *@lastModify:    2018-03-07
 *@description:   用户Mapper接口
 */
public interface UserInfoMapper extends BaseMapper{
	
	 /**
     * 根据账号查询密码
     * @param account   字符串
     * @return         影响记录条数
     * @throws Exception
     */
    public String findPasswordByAccount(String account) throws Exception;
    
    /**
     * 根据账号查询对象
     * @param account   字符串
     * @return         影响记录条数
     * @throws Exception
     */
    public UserInfo findByAccount(String account) throws Exception;
    

}
