package com.hello.model.pojo;

import java.util.Date;

public class FullPaymentHouse {
    private Integer fullPaymentHouseId;

    private Integer userId;

    private String userPhone;

    private Integer marketValue;

    private Integer rightOfPeoplenumber;

    private Date createTime;

    private Date updateTime;

    public Integer getFullPaymentHouseId() {
        return fullPaymentHouseId;
    }

    public void setFullPaymentHouseId(Integer fullPaymentHouseId) {
        this.fullPaymentHouseId = fullPaymentHouseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Integer getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(Integer marketValue) {
        this.marketValue = marketValue;
    }

    public Integer getRightOfPeoplenumber() {
        return rightOfPeoplenumber;
    }

    public void setRightOfPeoplenumber(Integer rightOfPeoplenumber) {
        this.rightOfPeoplenumber = rightOfPeoplenumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}