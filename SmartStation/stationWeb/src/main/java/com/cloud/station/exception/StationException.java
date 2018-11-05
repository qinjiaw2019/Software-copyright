package com.cloud.station.exception;

public class StationException extends Exception{
    StationException(){
        super("id must be null");
    }

    StationException(String msg){
        super(msg);
    }
}
