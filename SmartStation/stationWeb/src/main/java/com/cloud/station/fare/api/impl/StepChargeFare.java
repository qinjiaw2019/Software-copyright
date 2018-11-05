package com.cloud.station.fare.api.impl;




import com.cloud.station.fare.entity.BaseCharge;
import com.cloud.station.fare.entity.StepCharge;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StepChargeFare {

    public float calc(List<StepCharge> list, BaseCharge baseCharge, float time, Float max_money){
        float money = 0;

        //排序 安装区间排列
        Collections.sort(list, new Comparator<StepCharge>() {
            @Override
            public int compare(StepCharge o1, StepCharge o2) {
                if(o1.getT0()<o2.getT0())
                    return 1;
                else if(o1.getT0()<o2.getT0())
                    return -1;
                else
                    return 0;
            }
        });

        //计算费用
        for(StepCharge sc:list){
            if(time>=sc.getTn()){
                money+=(sc.getTn()-sc.getT0())*sc.getUnit()*sc.getPrice();
            }else{
                money+=(time-sc.getT0())*sc.getUnit()*sc.getPrice();
                break;
            }

        }


        if(baseCharge!=null){
            //打折
            if(baseCharge.getDiscount()!=null){
                if(baseCharge.getDiscount()>0 && baseCharge.getDiscount()<=1){
                    if(baseCharge.getDistime()!=null){
                        if(time>baseCharge.getDistime())money=money*baseCharge.getDiscount();
                    }
                }
            }

            //优惠元数
            if(baseCharge.getDismoney()!=null){
                if(baseCharge.getDismoney()>0){
                    if(time>baseCharge.getDistime())money-=baseCharge.getDismoney();
                }
            }
        }

        //如果存在最大收费
        if(max_money!=null){
            if(money>=max_money)money=max_money;
        }

        return money<=0?0:money;
    }
}
