package com.cloud.station.pojo;

/**
 * 用户绑定车牌实体
 */
public class CarNumberUsed {

    //ID
    private Long id;

    //车牌ID
    private Long carNumberId;

    private Long userId;

    //创建时间
    private Long createTime;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarNumberId() {
        return carNumberId;
    }

    public void setCarNumberId(Long carNumberId) {
        this.carNumberId = carNumberId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
