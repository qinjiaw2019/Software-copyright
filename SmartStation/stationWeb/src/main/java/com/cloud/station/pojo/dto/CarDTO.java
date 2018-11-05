package com.cloud.station.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 车辆类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO {

    private String number;//车牌号码
    private Long startTime;//初始时间
    private Long endTime;//结束时间
    private Long stationId;//停车场ID


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }
}
