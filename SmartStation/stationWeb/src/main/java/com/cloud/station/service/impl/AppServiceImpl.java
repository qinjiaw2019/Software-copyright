package com.cloud.station.service.impl;

import com.cloud.station.base.impl.BaseServiceImpl;
import com.cloud.station.service.AppService;

import java.util.List;

/**
 * @className:     AppServiceImpl
 * @data:          2018-03-06
 * @lastModify:    2018-03-06
 * @description:  手机APP公共Service实现类
 */
public class AppServiceImpl extends BaseServiceImpl implements AppService{

    /**
     * 获取对应平台最新的APP版本
     *
     * @param platform 平台
     * @return
     */
    @Override
    public String getLastVersion(String platform) {
        //从数据库查询
        return null;
    }

    /**
     * 更新手机APP版本
     * @param platform 平台
     * @param version  版本
     * @return
     */
    @Override
    public String updateApp(String platform,String version){
        //TODO 实现APK下载更新
        //暂时不用实现
        return null;
    }

    /**
     * 下载APP
     *
     * @param platform 平台
     * @param version  版本
     * @return
     */
    @Override
    public String dowloadApp(String platform, String version) {
        //TODO 下载APK
        //暂时不用实现
        return null;
    }

    //Override

    /**
     * 增加一条记录
     *
     * @param entity 实体
     * @return 影响记录条数
     * @
     */
    @Override
    public Integer save(Object entity) {
        return super.save(entity);
    }

    /**
     * 删除一条记录
     *
     * @param pk 主键或对象
     * @return 影响记录条数
     * @
     */
    @Override
    public Integer delete(Object pk) {
        return super.delete(pk);
    }

    /**
     * 更新一条记录
     *
     * @param entity 实体
     * @return 影响记录条数
     * @
     */
    @Override
    public Integer update(Object entity) {
        return super.update(entity);
    }

    /**
     * 查询
     *
     * @param entity 实体
     * @return List    集合
     * @
     */
    @Override
    public List find(Object entity) {
        return super.find(entity);
    }

    /**
     * 增加或更新一条记录
     *
     * @param entity 实体
     * @return 影响记录条数
     * @
     */
    @Override
    public Integer saveOrUpdate(Object entity) {
        return super.saveOrUpdate(entity);
    }

    /**
     * 根据主键删除一条记录
     *
     * @param pk 主键
     * @return 影响记录条数
     * @
     */
    @Override
    public Integer deleteByPrimaryKey(Object pk) {
        return super.deleteByPrimaryKey(pk);
    }

    /**
     * 根据名称删除
     *
     * @param name
     * @return
     * @
     */
    @Override
    public Integer deleteByName(String name) {
        return super.deleteByName(name);
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
        return super.findByPrimaryKey(obj);
    }
}
