package com.cloud.station.mapper;

import com.cloud.station.base.BaseMapper;
import com.cloud.station.pojo.Friend;
import com.cloud.station.pojo.UserInfo;
import com.cloud.station.pojo.ex.FriendEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @className:     FriendMapper
 * @data:          2018-04-13
 * @lastModify:    2018-04-13
 * @description:   好友 Mapper接口
 */
public interface FriendMapper extends BaseMapper{

    /**
     * 查询
     * @param myId 我的ID
     * @param relative 关系包含
     * @param unrelative 关系不包含
     * @param skip
     * @param limit
     * @return
     * @throws Exception
     */
    public List<FriendEx> getFriendList(@Param("myId") Long myId,
                                        @Param("relative")Integer relative,
                                        @Param("unrelative")Integer unrelative,
                                        @Param("skip")Integer skip,@Param("limit")Integer limit) throws Exception;

    /**
     * 条件统计
     * @param myId
     * @param relative
     * @param unrelative
     * @param skip
     * @param limit
     * @return
     * @throws Exception
     */
    public Long countByFilter(@Param("myId") Long myId,
                              @Param("relative")Integer relative,
                              @Param("unrelative")Integer unrelative) throws Exception;
}
