package com.cloud.station.fare.entity;


import java.io.Serializable;

public class BaseCharge implements Serializable{

    private Float discount;//折扣

    private Float dismoney;//减价多少

    private Float distime;//减价最小时间 配合dismoney|discount使用

    private float unit;//收费单元 (n小时收费，例如0.5)

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public float getUnit() {
        return unit;
    }

    public void setUnit(float unit) {
        this.unit = unit;
    }

    public Float getDismoney() {
        return dismoney;
    }

    public void setDismoney(Float dismoney) {
        this.dismoney = dismoney;
    }

    public Float getDistime() {
        return distime;
    }

    public void setDistime(Float distime) {
        this.distime = distime;
    }

    @Override
    public String toString() {
        return "BaseCharg{" +
                "discount=" + discount +
                ", unit=" + unit +
                '}';
    }
}
