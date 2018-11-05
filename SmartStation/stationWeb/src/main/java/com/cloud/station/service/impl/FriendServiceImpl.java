package com.cloud.station.service.impl;

import com.cloud.station.base.impl.BaseServiceImpl;
import com.cloud.station.mapper.FriendMapper;
import com.cloud.station.pojo.ex.FriendEx;
import com.cloud.station.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("friendService")
public class FriendServiceImpl extends BaseServiceImpl implements FriendService {

    @Autowired
    FriendMapper friendMapper;

    /**
     * 增加一条记录
     *
     * @param entity 实体
     * @return 影响记录条数
     * @
     */
    @Override
    public Integer save(Object entity) {
        try {
            return friendMapper.insert(entity);
        } catch (Exception e) {
            return 0;
        }
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
        try {
            return friendMapper.update(entity);
        } catch (Exception e) {
            return 0;
        }
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
        try {
            return friendMapper.find(entity);
        } catch (Exception e) {
            return null;
        }
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
        try {
            return friendMapper.deleteByPrimaryKey(pk);
        } catch (Exception e) {
            return 0;
        }
    }


    /**
     * 获取好友列表
     *
     * @param myId
     * @param relative
     * @param unrelative
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<FriendEx> getFriendList(Long myId, Integer relative, Integer unrelative, Integer page, Integer limit)  {
        try {
            return friendMapper.getFriendList(myId,relative,unrelative,(page-1)*limit,limit);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 条件查询总数
     *
     * @param myId
     * @param relative
     * @param unrelative
     * @return
     */
    @Override
    public Long countByFilter(Long myId, Integer relative, Integer unrelative) {
        try {
            return friendMapper.countByFilter(myId,relative,unrelative);
        } catch (Exception e) {
            return 0L;
        }
    }
}
