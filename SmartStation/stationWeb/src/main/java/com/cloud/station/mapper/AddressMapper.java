package com.cloud.station.mapper;

import com.cloud.station.base.BaseMapper;
import com.cloud.station.pojo.dto.MapAddressDTO;

import java.util.List;

/**
 * @className:     AddressMapper
 * @data:          2018-03-07
 * @lastModify:    2018-03-23
 * @description:   地址信息Mapper接口
 */
public interface AddressMapper extends BaseMapper{
    /**
     * 根据地址查找停车场的状态信息包括停车场的基本信息
     * @param mapAddressDTO
     * @return
     */
    public List findByMapAddress(MapAddressDTO mapAddressDTO);
}
