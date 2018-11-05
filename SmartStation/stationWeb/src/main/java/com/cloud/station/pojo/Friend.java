package com.cloud.station.pojo;

/**
 * 好友类
 */
public class Friend {

    //好友关系常量
    public static Integer GOOD_FRIEND = 0;//好朋友
    public static Integer STRANGER = 1;//陌生人
    public static Integer BLACK_LIST = 2;//被拉黑
    public static Integer FAMILY = 3;//家人
    public static Integer WORKERS = 4;//同事

    //ID
    private Long id;

    //我的ID
    private Long myId;

    //好友ID
    private Long frendId;


    //关系 默认是陌生人
    private Integer relative;

    //添加时间
    private Long createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMyId() {
        return myId;
    }

    public void setMyId(Long myId) {
        this.myId = myId;
    }

    public Long getFrendId() {
        return frendId;
    }

    public void setFrendId(Long frendId) {
        this.frendId = frendId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getRelative() {
        return relative;
    }

    public void setRelative(Integer relative) {
        this.relative = relative;
    }
}
