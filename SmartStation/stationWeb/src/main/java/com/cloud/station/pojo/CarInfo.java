package com.cloud.station.pojo;

/**
 * 车牌实体
 */
public class CarInfo {

    //ID
    private Long id;

    //车牌
    private String carNumber;

    //当前使用者ID（0：车主）
    private Long currentUsed;

    //车主ID
    private Long userId;

    //车牌类别
    private String carNumberType;

    //车辆牌照
    private String photo;

    //车辆品牌
    private String carType;

    //车辆型号
    private String carXH;

    //车辆年份
    private Integer carYear;

    //车身颜色
    private String carColor;

    //识别号码
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Long getCurrentUsed() {
        return currentUsed;
    }

    public void setCurrentUsed(Long currentUsed) {
        this.currentUsed = currentUsed;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCarNumberType() {
        return carNumberType;
    }

    public void setCarNumberType(String carNumberType) {
        this.carNumberType = carNumberType;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarXH() {
        return carXH;
    }

    public void setCarXH(String carXH) {
        this.carXH = carXH;
    }

    public Integer getCarYear() {
        return carYear;
    }

    public void setCarYear(Integer carYear) {
        this.carYear = carYear;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CarInfo{" +
                "id=" + id +
                ", carNumber='" + carNumber + '\'' +
                ", currentUsed=" + currentUsed +
                ", userId=" + userId +
                ", carNumberType='" + carNumberType + '\'' +
                ", photo='" + photo + '\'' +
                ", carType='" + carType + '\'' +
                ", carXH='" + carXH + '\'' +
                ", carYear=" + carYear +
                ", carColor='" + carColor + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
