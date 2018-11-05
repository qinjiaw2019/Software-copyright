package com.cloud.station.mapper;


import com.cloud.station.base.BaseMapper;
import com.cloud.station.pojo.StationOrder;
import com.cloud.station.pojo.UserInfo;
import com.cloud.station.pojo.ex.StationOrderUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StationOrderMapper extends BaseMapper {

    /**
     * 根据时间段多条件查询
     * @param stationOrder 实体类
     * @param start 开始时间
     * @param end   结束时间
     * @return
     * @throws Exception
     */
    public List<StationOrder> findByTime(@Param("order")StationOrder stationOrder,
                           @Param("start")Long start,@Param("end")Long end,
                           @Param("skip")Integer skip,@Param("limit")Integer limit)throws Exception;

    /**
     * 根据实体查询用户信息
     * @param stationOrder
     * @return
     * @throws Exception
     */
    public List<StationOrderUser> findUserByEntity(@Param("order") StationOrder stationOrder,
                                                   @Param("skip")Integer page,@Param("limit")Integer limit) throws Exception;

    /**
     * 根据停车场ID和车牌查询未支付的记录
     * @param stationId
     * @param carNum
     * @return
     * @throws Exception
     */
    public StationOrder findByStationIdAndCarNuber(Long stationId, String carNum) throws Exception;


}
