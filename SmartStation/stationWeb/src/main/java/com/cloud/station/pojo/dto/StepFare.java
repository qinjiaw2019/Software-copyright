package com.cloud.station.pojo.dto;

/**
 * 梯步区间类
 * 整个区间费用=(t1-t0)*money*unit
 */
public class StepFare {

    //时间t0
    private int t0;

    //时间t1
    private int t1;

    //价格
    private float money;

    //小时数
    private float unit;

    public int getT0() {
        return t0;
    }

    /**
     * 整个区间的费用
     * @return
     */
    public float calc(){
        return (this.t1-this.t0)*this.money*this.unit;
    }

    public void setT0(int t0) {
        this.t0 = t0;
    }

    public int getT1() {
        return t1;
    }

    public void setT1(int t1) {
        this.t1 = t1;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public float getUnit() {
        return unit;
    }

    public void setUnit(float unit) {
        this.unit = unit;
    }
}
