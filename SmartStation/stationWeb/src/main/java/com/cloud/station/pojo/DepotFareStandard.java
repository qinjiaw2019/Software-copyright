package com.cloud.station.pojo;

/**
 * 计费规则
 */
public class DepotFareStandard {

    //ID
    private Long id;

    //停车场ID
    private Long depotId;


    //免费结束时间(单位小时)
    private Float freeEndTime;

    //freeEndTime内收费  >0有效
    private Float freeTimeMoney;

    //梯步价格 JSON字符串
    private String fareStep;

    //梯步价最大值（超过这个时间的收费标准）(单位小时)
    private Float stepEndTime;

    //车型号（与收费标准有关例如：小型车 大型车）
    private String carType;

    //添加时间
    private Long createTime;

    //收费单元（小时数，1:每一小时，0.5：每半小时） 默认0.5小时
    private Float fareUnit;

    //折扣
    private Float discount;

    //优惠金额
    private Float discountMoney;

    //最多收费
    private Float maxMoney;

    //超过梯步价格后的收费标准
    private Float stepOutFare;

    //不超过时间（配合max_money来说）（小时）
    private Float maxTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepotId() {
        return depotId;
    }

    public Float getFreeTimeMoney() {
        return freeTimeMoney;
    }

    public Float getStepOutFare() {
        return stepOutFare;
    }

    public void setStepOutFare(Float stepOutFare) {
        this.stepOutFare = stepOutFare;
    }

    public void setFreeTimeMoney(Float freeTimeMoney) {
        this.freeTimeMoney = freeTimeMoney;
    }

    public void setDepotId(Long depotId) {
        this.depotId = depotId;
    }


    public Float getFreeEndTime() {
        return freeEndTime;
    }

    public void setFreeEndTime(Float freeEndTime) {
        this.freeEndTime = freeEndTime;
    }

    public String getFareStep() {
        return fareStep;
    }

    public void setFareStep(String fareStep) {
        this.fareStep = fareStep;
    }

    public Float getStepEndTime() {
        return stepEndTime;
    }

    public void setStepEndTime(Float stepEndTime) {
        this.stepEndTime = stepEndTime;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Float getFareUnit() {
        return fareUnit;
    }

    public void setFareUnit(Float fareUnit) {
        this.fareUnit = fareUnit;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Float getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(Float discountMoney) {
        this.discountMoney = discountMoney;
    }

    public Float getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(Float maxMoney) {
        this.maxMoney = maxMoney;
    }

    public Float getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Float maxTime) {
        this.maxTime = maxTime;
    }
}
