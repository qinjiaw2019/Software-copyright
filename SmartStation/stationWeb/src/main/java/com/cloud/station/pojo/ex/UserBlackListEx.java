package com.cloud.station.pojo.ex;


import com.cloud.station.pojo.CarNumberBlacklist;
import com.cloud.station.pojo.UserInfo;

public class UserBlackListEx extends CarNumberBlacklist {

    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
