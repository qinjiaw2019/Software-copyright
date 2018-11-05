package com.cloud.station.pojo.dto;


import com.cloud.station.pojo.DepotInfo;

public class StationStateDTO {

    private Long stationId;//停车场ID

    private Integer left;//车位剩余数量

    private Long lastTime;//最近更新时间
    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Long getLastTime() {
        return lastTime;
    }

    public void setLastTime(Long lastTime) {
        this.lastTime = lastTime;
    }
}
