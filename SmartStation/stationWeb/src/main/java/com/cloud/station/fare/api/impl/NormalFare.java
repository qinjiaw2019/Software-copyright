package com.cloud.station.fare.api.impl;


import com.cloud.station.fare.entity.Normal;

/**
 * 正常计费
 */
public class NormalFare {

    public float calc(Normal normal, float time){
        float money = 0;
        if(time>normal.getT0()){
            money = (time-normal.getT0())*normal.getUnit()*normal.getPrice();
        }

        //优惠
        if(normal.getDiscount()!=null){
            if(time>normal.getDistime()){
                if(normal.getDiscount()>0 && normal.getDiscount()<=1)
                    money=money*normal.getDiscount();
            }
        }

        if(normal.getDismoney()!=null){
            if(time>normal.getDistime())
                money-=normal.getDismoney();
        }

        return money<=0?0:money;
    }
}
