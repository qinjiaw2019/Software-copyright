package com.cloud.station.pojo.dto;

/**
 * 区域坐标(经纬度)
 */
public class Position {

    /**
     * 中心点边界点的经纬度
     */
    private double leftTopLat;
    private double leftTopLng;

    private double rightTopLat;
    private double rightTopLng;

    private double leftBottomLat;
    private double leftBottomLng;

    private double rightBottomLat;
    private double rightBottomLng;

    //中心点经纬度
    private double centerLat;
    private double centerLng;

    public double getLeftTopLat() {
        return leftTopLat;
    }

    public void setLeftTopLat(double leftTopLat) {
        this.leftTopLat = leftTopLat;
    }

    public double getLeftTopLng() {
        return leftTopLng;
    }

    public void setLeftTopLng(double leftTopLng) {
        this.leftTopLng = leftTopLng;
    }

    public double getRightTopLat() {
        return rightTopLat;
    }

    public void setRightTopLat(double rightTopLat) {
        this.rightTopLat = rightTopLat;
    }

    public double getRightTopLng() {
        return rightTopLng;
    }

    public void setRightTopLng(double rightTopLng) {
        this.rightTopLng = rightTopLng;
    }

    public double getLeftBottomLat() {
        return leftBottomLat;
    }

    public void setLeftBottomLat(double leftBottomLat) {
        this.leftBottomLat = leftBottomLat;
    }

    public double getLeftBottomLng() {
        return leftBottomLng;
    }

    public void setLeftBottomLng(double leftBottomLng) {
        this.leftBottomLng = leftBottomLng;
    }

    public double getRightBottomLat() {
        return rightBottomLat;
    }

    public void setRightBottomLat(double rightBottomLat) {
        this.rightBottomLat = rightBottomLat;
    }

    public double getRightBottomLng() {
        return rightBottomLng;
    }

    public void setRightBottomLng(double rightBottomLng) {
        this.rightBottomLng = rightBottomLng;
    }

    public double getCenterLat() {
        return centerLat;
    }

    public void setCenterLat(double centerLat) {
        this.centerLat = centerLat;
    }

    public double getCenterLng() {
        return centerLng;
    }

    public void setCenterLng(double centerLng) {
        this.centerLng = centerLng;
    }

    @Override
    public String toString() {
        return "Position{" +
                "leftTopLat=" + leftTopLat +
                ", leftTopLng=" + leftTopLng +
                ", rightTopLng=" + rightTopLng +
                ", leftBottomLat=" + leftBottomLat +
                '}';
    }
}
