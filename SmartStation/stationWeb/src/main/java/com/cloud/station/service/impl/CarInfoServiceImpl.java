package com.cloud.station.service.impl;

import com.cloud.station.base.impl.BaseServiceImpl;
import com.cloud.station.mapper.CarInfoMapper;
import com.cloud.station.pojo.CarInfo;
import com.cloud.station.service.AppService;
import com.cloud.station.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className:     AppServiceImpl
 * @data:          2018-03-06
 * @lastModify:    2018-03-06
 * @description:  手机APP公共Service实现类
 */
@Service("carInfoService")
public class CarInfoServiceImpl implements CarInfoService{

    @Autowired
    CarInfoMapper carInfoMapper;

    /**
     * 根据实体查询
     *
     * @param carInfo
     * @return
     */
    @Override
    public List get(CarInfo carInfo,Integer page,Integer limit) {
        try {
            return carInfoMapper.find(carInfo,(page-1)*limit,limit);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 统计总记录数
     *
     * @param carInfo
     * @return
     */
    @Override
    public Long count(CarInfo carInfo) {
        try {
            return carInfoMapper.count(carInfo);
        } catch (Exception e) {
            return 0L;
        }
    }

    /**
     * 添加
     *
     * @param carInfo
     * @return
     */
    @Override
    public Integer add(CarInfo carInfo) {
        try {
            return carInfoMapper.insert(carInfo);
        } catch (Exception e) {
            return 0;
        }
    }
}
