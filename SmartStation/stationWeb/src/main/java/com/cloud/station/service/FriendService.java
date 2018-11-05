package com.cloud.station.service;

import com.cloud.station.base.BaseService;
import com.cloud.station.pojo.ex.FriendEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface FriendService extends BaseService{

    /**
     * 获取好友列表
     * @param myId
     * @param relative
     * @param unrelative
     * @param page
     * @param limit
     * @return
     */
    public List<FriendEx> getFriendList(Long myId,Integer relative,
                                        Integer unrelative,Integer page,
                                        Integer limit);

    /**
     * 条件查询总数
     * @param myId
     * @param relative
     * @param unrelative
     * @return
     */
    public Long  countByFilter(Long myId,Integer relative,
                                        Integer unrelative);

}
