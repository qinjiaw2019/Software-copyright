package com.cloud.station.service;

import java.util.List;

import com.cloud.station.pojo.dto.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.station.base.BaseService;
import com.cloud.station.mapper.DepotInfoMapper;
import com.cloud.station.pojo.Address;
import com.cloud.station.pojo.AdminInfo;
import com.cloud.station.pojo.DepotAdminInfo;
import com.cloud.station.pojo.DepotInfo;
import com.cloud.station.pojo.UserInfo;

/**
 * @className:     DepotInfoService
 * @data:          2018-03-07
 * @lastModify:    2018-03-07
 * @description:   停车场基本信息service接口
 */

public interface DepotInfoService extends BaseService {

    /**
     * 根据经纬度查询
     * @param position 经纬度范围
     * @param skip   跳过记录条数
     * @param limit  每页条数
     * @return
     */
    public List getByLatAndLon(Position position, int skip, int limit);

    /**
     * 根据经纬度查询
     * @param lat 中心经纬
     * @Param lng  中心纬度
     * @Param dis  中心覆盖距离
     * @param skip   跳过记录条数
     * @param limit  每页条数
     * @return
     */
    public List getByLatAndLon(double lat,double lng,double dis, int skip, int limit);

    /**
     * 根据车牌查找实体
     * @param carNum
     * @return
     */
    public DepotInfo getByCarNumber(String carNum);
}
