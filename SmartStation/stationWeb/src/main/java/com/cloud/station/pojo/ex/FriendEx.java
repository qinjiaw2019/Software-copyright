package com.cloud.station.pojo.ex;


import com.cloud.station.pojo.UserInfo;

public class FriendEx extends UserInfo{

    //关系 默认是陌生人
    private Integer relative;

    //好友添加时间
    private Long addTime;

    public Integer getRelative() {
        return relative;
    }

    public void setRelative(Integer relative) {
        this.relative = relative;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }
}
