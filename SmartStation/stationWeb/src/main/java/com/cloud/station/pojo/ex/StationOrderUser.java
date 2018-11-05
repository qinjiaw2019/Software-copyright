package com.cloud.station.pojo.ex;

import com.cloud.station.pojo.UserInfo;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StationOrderUser extends UserInfo{

    //订单创建时间
    private Long orderCreateTime;

    //订单提价时间
    private Long orderEndTime;

    //订单的状态
    private Integer orderState;
}
