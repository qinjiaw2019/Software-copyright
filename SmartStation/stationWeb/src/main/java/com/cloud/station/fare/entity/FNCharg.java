package com.cloud.station.fare.entity;

/**
 * 前n小时收费问题
 * t0-tn
 */
public class FNCharg extends BaseCharge {
    private Float t0;//收费起点
    private Float tn;//收费终点

    private float price;//单价

    public Float getT0() {
        return t0;
    }

    public void setT0(Float t0) {
        this.t0 = t0;
    }

    public void setTn(Float tn) {
        this.tn = tn;
    }

    public Float getTn() {
        return tn;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ChargFN{" +
                "t0=" + t0 +
                ", tn=" + tn +
                ", price=" + price +
                '}';
    }
}
