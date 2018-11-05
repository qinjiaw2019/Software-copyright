package com.cloud.station.algorithm;

import com.cloud.station.pojo.dto.Position;

/**
 * 距离算法类
 */
public class Distance {

    /**
     * 计算以(lat,lng)为中心点len范围的边界
     * @param lat 中心点的精度
     * @param lng 中心点的纬度
     * @param len 覆盖范围(米)
     * @return
     */
    public static Position calcPosition(double lat,double lng,double len){
        double R = 6371.137;//R为地球半径，可取平均值 6371.137km
        double dlng = 2*Math.asin(Math.sin(len/(2*R))/Math.cos(lat*Math.PI/180));  //⊿λ东西两侧的的范围边界
        dlng = dlng*180/Math.PI;//角度转为弧度
        double dlat = len/R;  //⊿φ南北两侧的范围边界
        dlat = dlat*180/Math.PI;

        /**
         * 最后，就可以得出四个点的坐标：
         left-top : (lat + dlat, lng – dlng) right-top : (lat + dlat, lng + dlng)

         left-bottom : (lat – dlat, lng – dlng) right-bottom: (lat – dlat, lng + dlng)
         */
        Position position = new Position();
        position.setLeftTopLat(lat + dlat);
        position.setLeftTopLng(lng - dlng);

        position.setRightTopLat(lat+dlat);
        position.setRightTopLng(lng + dlng);

        position.setLeftBottomLat(lat - dlat);
        position.setLeftBottomLng(lng - dlng);

        position.setRightBottomLat(lat - dlat);
        position.setRightBottomLng(lng + dlng);

        position.setCenterLat(lat);
        position.setCenterLng(lng);
        return position;
    }
}
