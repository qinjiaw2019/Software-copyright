package com.cloud.station.pojo.dto;

/**
 * 地址信息DTO类
 */
public class AddressDTO {
    private double lat;//目标地址经度
    private double lng;//目标地址纬度
    private double distance;//目标地址覆盖半径（米）
    private double step;//增量幅度

    private Long sid;//首选停车场ID

    private int page;//当前页码
    private int limit;//每页数据条数

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }
}
