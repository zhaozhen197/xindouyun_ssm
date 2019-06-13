package com.hello.model.pojo;

import java.util.Date;

public class WageEarner {
    private Integer wageEarnerId;

    private Integer userId;

    private String userphone;

    private String salaryType;

    private String punchTime;

    private String companytype;

    private Date createTime;

    private Date updateTime;

    public Integer getWageEarnerId() {
        return wageEarnerId;
    }

    public void setWageEarnerId(Integer wageEarnerId) {
        this.wageEarnerId = wageEarnerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType == null ? null : salaryType.trim();
    }

    public String getPunchTime() {
        return punchTime;
    }

    public void setPunchTime(String punchTime) {
        this.punchTime = punchTime == null ? null : punchTime.trim();
    }

    public String getCompanytype() {
        return companytype;
    }

    public void setCompanytype(String companytype) {
        this.companytype = companytype == null ? null : companytype.trim();
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