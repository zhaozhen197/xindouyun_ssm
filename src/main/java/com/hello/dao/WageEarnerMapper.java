package com.hello.dao;

import com.hello.model.pojo.WageEarner;

public interface WageEarnerMapper {
    int deleteByPrimaryKey(Integer wageEarnerId);

    int insert(WageEarner record);

    int insertSelective(WageEarner record);

    WageEarner selectByPrimaryKey(Integer wageEarnerId);

    int updateByPrimaryKeySelective(WageEarner record);

    int updateByPrimaryKey(WageEarner record);

    WageEarner getWageEarnerByUserId(int userId);

}