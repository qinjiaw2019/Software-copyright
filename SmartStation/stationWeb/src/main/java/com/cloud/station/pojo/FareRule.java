package com.cloud.station.pojo;

/**
 * 计费规则类
 */
public class FareRule {

    //ID
    private Long id;

    //停车场ID
    private Long stationId;

    //创建时间
    private Long createTime;

    //计费规则
    private String rule;

    //模式
    private Integer mode;

    //描述
    private String desc;

    //是否被使用 0:No 1:Yes
    private Integer used;

    //创建者ID
    private Long userId;


    //规则名称
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "FareRule{" +
                "id=" + id +
                ", stationId=" + stationId +
                ", createTime=" + createTime +
                ", rule='" + rule + '\'' +
                ", mode=" + mode +
                ", desc='" + desc + '\'' +
                ", used=" + used +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                '}';
    }
}
