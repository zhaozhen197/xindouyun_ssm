package com.hello.model.pojo;

import java.util.Date;

public class MortgageCar {
    private Integer mortgageCarId;

    private Integer userId;

    private String userPhone;

    private Integer moneyEveryMonthCar;

    private Integer monthOfLoanCar;

    private Date createTime;

    private Date updateTime;

    public Integer getMortgageCarId() {
        return mortgageCarId;
    }

    public void setMortgageCarId(Integer mortgageCarId) {
        this.mortgageCarId = mortgageCarId;
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

    public Integer getMoneyEveryMonthCar() {
        return moneyEveryMonthCar;
    }

    public void setMoneyEveryMonthCar(Integer moneyEveryMonthCar) {
        this.moneyEveryMonthCar = moneyEveryMonthCar;
    }

    public Integer getMonthOfLoanCar() {
        return monthOfLoanCar;
    }

    public void setMonthOfLoanCar(Integer monthOfLoanCar) {
        this.monthOfLoanCar = monthOfLoanCar;
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