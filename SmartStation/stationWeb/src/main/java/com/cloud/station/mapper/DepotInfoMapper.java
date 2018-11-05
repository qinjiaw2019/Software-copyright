package com.cloud.station.mapper;

import com.cloud.station.base.BaseMapper;
import com.cloud.station.pojo.dto.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @className:     DepotInfoMapper
 * @data:          2018-03-07
 * @lastModify:    2018-03-07
 * @description:   停车场信息Mapper接口
 */
public interface DepotInfoMapper extends BaseMapper{
    /**
     * 根据经纬度查询
     * @param position 经纬度范围
     * @param skip   跳过记录条数
     * @param limit  每页条数
     * @return
     */
    public List findByLatAndLon(@Param("position") Position position,
                               @Param("skip") int skip,@Param("limit") int limit) throws Exception;
}
