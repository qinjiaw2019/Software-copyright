package com.cloud.station.utils;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class MapUtils {

    public static ArrayList toList(Map map){
        Collection valueCollection = map.values();
        return new ArrayList<>(valueCollection);
    }
}
