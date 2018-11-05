package com.cloud.station.pojo.dto;

import com.cloud.station.pojo.Address;

/**
 * 地图地址DTO
 */
public class MapAddressDTO extends Address{

    //街道编号
    private String citycode;

    private String neighborhood;

    //街
    private String street;

    //道
    private String township;

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }


    @Override
    public String toString() {
        return "MapAddressDTO{" +
                "citycode='" + citycode + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", street='" + street + '\'' +
                ", township='" + township + '\'' +
                '}';
    }
}
