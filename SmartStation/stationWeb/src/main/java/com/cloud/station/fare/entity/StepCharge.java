package com.cloud.station.fare.entity;

/**
 * 梯步价格收费
 * [t0-t1] price元
 */
public class StepCharge extends BaseCharge {
    private Float t0;
    private Float tn;

    private float price;

    public Float getT0() {
        return t0;
    }

    public void setT0(Float t0) {
        this.t0 = t0;
    }

    public Float getTn() {
        return tn;
    }

    public void setTn(Float tn) {
        this.tn = tn;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "StepCharge{" +
                "t0=" + t0 +
                ", tn=" + tn +
                ", price=" + price +
                '}';
    }
}
