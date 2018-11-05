package com.cloud.station.fare.api.impl;



import com.cloud.station.fare.entity.BaseCharge;
import com.cloud.station.fare.entity.DayCharge;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DayFare {

    /**
     * @param list
     * @param baseCharge
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public float calc(List<DayCharge> list, BaseCharge baseCharge, float startTime,float endTime){
        float money = 0;
        //排序 安装区间排列
        Collections.sort(list, new Comparator<DayCharge>() {
            @Override
            public int compare(DayCharge o1, DayCharge o2) {
                if(o1.getT0()<o2.getT0())
                    return -1;
                else if(o1.getT0()>o2.getT0())
                    return 1;
                else
                    return 0;
            }
        });
        boolean flag = false;//是否找到匹配的区间
        for(DayCharge dc:list){
            if(startTime>=dc.getT0()&& startTime<dc.getTn()){//
                money+=(dc.getTn()-startTime)*dc.getUnit()*dc.getPrice();
                flag = true;
            }

            if(flag){
                if(endTime>dc.getTn()){
                    money+=(dc.getTn()-dc.getT0())*dc.getUnit()*dc.getPrice();
                }else{
                    money+=(endTime-dc.getT0())*dc.getUnit()*dc.getPrice();
                    break;
                }
            }
        }

        //优惠
        if(baseCharge!=null){
            //折扣
            if(baseCharge.getDiscount()!=null){
                if(baseCharge.getDiscount()>0 && baseCharge.getDiscount()<=1)
                    if((endTime-startTime)>=baseCharge.getDistime())money=money*baseCharge.getDiscount();
            }

            if(baseCharge.getDismoney()!=null){
                if((endTime-startTime)>=baseCharge.getDistime())money-=baseCharge.getDismoney();
            }
        }
        return money<=0?0:money;
    }
}
