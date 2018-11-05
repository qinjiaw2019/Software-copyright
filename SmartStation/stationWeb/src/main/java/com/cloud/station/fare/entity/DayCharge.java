package com.cloud.station.fare.entity;

/**
 * 一天的费用
 * 0-24小时之间
 */
public class DayCharge extends BaseCharge{
    private float t0;//小时数
    private float tn;//小时数

    private float price;

    public float getT0() {
        return t0;
    }

    public void setT0(float t0) {
        this.t0 = t0;
    }

    public float getTn() {
        return tn;
    }

    public void setTn(float tn) {
        this.tn = tn;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
