package com.cloud.station.service.impl;

import com.cloud.station.base.impl.BaseServiceImpl;
import com.cloud.station.mapper.AdminInfoMapper;
import com.cloud.station.pojo.AdminInfo;
import com.cloud.station.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminInfoService")
public class AdminInfoServiceImpl extends BaseServiceImpl implements AdminInfoService{

    @Autowired
    AdminInfoMapper adminInfoMapper;
    /**
     * 根据用户名查询密码
     *
     * @param account
     * @return
     */
    @Override
    public String getPasswordByAccount(String account) {
        try {
            return adminInfoMapper.findPasswordByAccount(account);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据用户名查询用户的基本信息
     *
     * @param account
     * @return
     */
    @Override
    public AdminInfo getDepotAdminInfoByAccount(String account) {
        try{
            return (AdminInfo) (adminInfoMapper.findByName(account)).get(0);
        }catch(Exception e){
            return null;
        }
    }

    /**
     * 更具主键查询一条记录
     *
     * @param obj 主键
     * @return 对象实体
     * @
     */
    @Override
    public Object findByPrimaryKey(Object obj) {
        try {
            return adminInfoMapper.findByPrimaryKey(obj);
        } catch (Exception e) {
            return null;
        }
    }
}
