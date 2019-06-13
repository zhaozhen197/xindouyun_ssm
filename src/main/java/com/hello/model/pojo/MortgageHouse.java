package com.hello.model.pojo;

import java.util.Date;

public class MortgageHouse {
    private Integer mortgageHouseId;

    private Integer userId;

    private String userPhone;

    private Integer mianLoanPerson;

    private Integer moneyEveryMonthHouse;

    private Integer monthOfLoanHouse;

    private Date createTime;

    private Date updateTime;

    public Integer getMortgageHouseId() {
        return mortgageHouseId;
    }

    public void setMortgageHouseId(Integer mortgageHouseId) {
        this.mortgageHouseId = mortgageHouseId;
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

    public Integer getMianLoanPerson() {
        return mianLoanPerson;
    }

    public void setMianLoanPerson(Integer mianLoanPerson) {
        this.mianLoanPerson = mianLoanPerson;
    }

    public Integer getMoneyEveryMonthHouse() {
        return moneyEveryMonthHouse;
    }

    public void setMoneyEveryMonthHouse(Integer moneyEveryMonthHouse) {
        this.moneyEveryMonthHouse = moneyEveryMonthHouse;
    }

    public Integer getMonthOfLoanHouse() {
        return monthOfLoanHouse;
    }

    public void setMonthOfLoanHouse(Integer monthOfLoanHouse) {
        this.monthOfLoanHouse = monthOfLoanHouse;
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