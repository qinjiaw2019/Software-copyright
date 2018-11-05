package com.cloud.station.fare.api.impl;


import com.cloud.station.fare.entity.FNCharg;

public class FrontN {

    public float calc(FNCharg chargFN, float time){
        float money = 0;
        if(time>chargFN.getTn()){
            money = (chargFN.getTn()-chargFN.getT0())*chargFN.getUnit()*chargFN.getPrice();
        }else{
            money = (time-chargFN.getT0())*chargFN.getUnit()*chargFN.getPrice();
        }

        //计算折扣
        if(chargFN.getDiscount()!=null){
            if(chargFN.getDiscount()>0 && chargFN.getDiscount()<=1)
                if(chargFN.getDistime()!=null && time>=chargFN.getDistime()){//达到折扣时间
                    money=money*chargFN.getDiscount();
                }
        }

        //计算优惠
        if(chargFN.getDismoney()!=null){
            if(chargFN.getDismoney()>0){
                if(chargFN.getDistime()!=null && time>=chargFN.getDistime()){
                    money-=chargFN.getDismoney();
                }
            }
        }
        return money;
    }
}
