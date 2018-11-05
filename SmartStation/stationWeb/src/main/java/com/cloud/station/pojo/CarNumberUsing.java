package com.cloud.station.pojo;

/**
 * 用户使用车牌实体
 */
public class CarNumberUsing {

    //ID
    private Long id;

    //车牌ID
    private Long carNumberId;

    //使用开始时间
    private Long starTime;

    //使用结束时间
    private Long endTime;

    //使用人
    private Long userId;

    //使用状态（1：正在使用，-1：过期，2：使用完成）
    private Integer state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarNumberId() {
        return carNumberId;
    }

    public void setCarNumberId(Long carNumberId) {
        this.carNumberId = carNumberId;
    }

    public Long getStarTime() {
        return starTime;
    }

    public void setStarTime(Long starTime) {
        this.starTime = starTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
