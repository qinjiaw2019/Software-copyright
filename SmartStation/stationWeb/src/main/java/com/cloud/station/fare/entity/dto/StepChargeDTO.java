package com.cloud.station.fare.entity.dto;


import com.cloud.station.fare.entity.BaseCharge;
import com.cloud.station.fare.entity.FNCharg;
import com.cloud.station.fare.entity.Normal;
import com.cloud.station.fare.entity.StepCharge;

import java.util.List;

public class StepChargeDTO {
    private BaseCharge baseCharge;
    private List<StepCharge> stepChargeList;
    private Normal normal;
    private FNCharg fnCharg;
    private Float max_money;//最多收费

    public BaseCharge getBaseCharge() {
        return baseCharge;
    }

    public void setBaseCharge(BaseCharge baseCharge) {
        this.baseCharge = baseCharge;
    }

    public List<StepCharge> getStepChargeList() {
        return stepChargeList;
    }

    public void setStepChargeList(List<StepCharge> stepChargeList) {
        this.stepChargeList = stepChargeList;
    }

    public Normal getNormal() {
        return normal;
    }

    public void setNormal(Normal normal) {
        this.normal = normal;
    }

    public FNCharg getFnCharg() {
        return fnCharg;
    }

    public void setFnCharg(FNCharg fnCharg) {
        this.fnCharg = fnCharg;
    }

    public Float getMax_money() {
        return max_money;
    }

    public void setMax_money(Float max_money) {
        this.max_money = max_money;
    }
}
