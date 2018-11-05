package com.cloud.station.mapper;


import com.cloud.station.base.BaseMapper;
import com.cloud.station.pojo.CarInfo;
import com.cloud.station.pojo.StationOrder;
import com.cloud.station.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarInfoMapper extends BaseMapper{

    /**
     * 查询用户信息
     * @param carInfo
     * @return
     * @throws Exception
     */
    public UserInfo getUser(CarInfo carInfo)throws Exception;

    /**
     * 根据车牌查询实体
     * @param carNumber
     * @return
     * @throws Exception
     */
    public CarInfo getByCarNumber(String carNumber)throws Exception;

    /**
     * 获取用户绑定的所有车牌信息
     * 包括车主自己的和绑定其他的车辆
     * @param userId
     * @return
     * @throws Exception
     */
    public List getAll(Long userId) throws Exception;

    /**
     * 查询
     * @param carInfo
     * @return
     * @throws Exception
     */
    public List find(@Param("carInfo") CarInfo carInfo,@Param("skip") Integer skip,@Param("limit") Integer limit) throws Exception;

    /**
     * 过滤统计总记录数
     * @param carInfo
     * @return
     * @throws Exception
     */
    public Long count(CarInfo carInfo) throws Exception;

}
