package com.cloud.station.mapper;

import com.cloud.station.base.BaseMapper;

/**
 * @className:     DepotAdminInfoMapper
 * @data:          2018-03-07
 * @lastModify:    2018-03-07
 * @description:   停车场管理员Mapper接口
 */
public interface DepotAdminInfoMapper extends BaseMapper{
	
	/**
     * 根据账号查询密码
     * @param account   字符串
     * @return         影响记录条数
     * @throws Exception
     */
    public String findPasswordByAccount(String account) throws Exception;

}
