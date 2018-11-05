package com.cloud.station.fare.entity.dto;


import com.cloud.station.fare.entity.BaseCharge;
import com.cloud.station.fare.entity.DayCharge;

import java.util.List;

public class DayChargeDTO {

    private List<DayCharge> dayChargeList;

    private BaseCharge baseCharge;

    private float startTime;//开始时间
    private float endTime;//结束时间

    public List<DayCharge> getDayChargeList() {
        return dayChargeList;
    }

    public void setDayChargeList(List<DayCharge> dayChargeList) {
        this.dayChargeList = dayChargeList;
    }

    public BaseCharge getBaseCharge() {
        return baseCharge;
    }

    public void setBaseCharge(BaseCharge baseCharge) {
        this.baseCharge = baseCharge;
    }

    @Override
    public String toString() {
        return "DayChargeDTO{" +
                "dayChargeList=" + dayChargeList +
                ", baseCharge=" + baseCharge +
                '}';
    }
}
