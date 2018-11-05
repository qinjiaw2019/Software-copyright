package com.cloud.station.mapper;

import com.cloud.station.base.BaseMapper;

/**
 * @className:     AdminInfoMapper
 * @date:          2018-03-07
 * @lastModify:    2018-03-07
 * @description:   系统管理员Mapper接口
 */
public interface AdminInfoMapper extends BaseMapper{

    /**
     * 根据账号查询密码
     * @param account   字符串
     * @return         影响记录条数
     * @throws Exception
     */
    public String findPasswordByAccount(String account) throws Exception;

}
