package com.cloud.station.fare.entity;

/**
 * 正常计费，或者超过梯步价计费
 */
public class Normal extends BaseCharge{
    private float price;//费用
    private float t0;//开始时刻点

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getT0() {
        return t0;
    }

    public void setT0(float t0) {
        this.t0 = t0;
    }
}
