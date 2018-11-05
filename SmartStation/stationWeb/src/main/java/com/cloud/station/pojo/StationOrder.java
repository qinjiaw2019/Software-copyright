package com.cloud.station.pojo;

/**
 * 停车场使用记录以及预约实体
 */
public class StationOrder {
    public static Integer NORMAL = 1;//正常完成
    public static Integer USER_CANCEL=2;//用户取消
    public static Integer UNDO = 3;//未处理
    public static Integer UNDO_MONEY = 4;//欠费


    //ID
    private Long id;

    //停车场ID
    private Long stationId;

    //用户ID
    private Long userId;

    //创建时间
    private Long createTime;

    //订单提交时间
    private Long endTime;

    //状态
    private Integer state;

    //车牌
    private String carNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }
}
