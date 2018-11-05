package com.cloud.station.fare.entity;

/**
 * 规则信息
 */
public class Rule {

    private String rule;

    private Integer mode;//模式
    private int totalTime;//总时间

    private float startTime;//开始时间
    private float endTime;//结束时间

    private float max_money;//最多收费

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public float getMax_money() {
        return max_money;
    }

    public void setMax_money(float max_money) {
        this.max_money = max_money;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public float getStartTime() {
        return startTime;
    }

    public void setStartTime(float startTime) {
        this.startTime = startTime;
    }

    public float getEndTime() {
        return endTime;
    }

    public void setEndTime(float endTime) {
        this.endTime = endTime;
    }
}
