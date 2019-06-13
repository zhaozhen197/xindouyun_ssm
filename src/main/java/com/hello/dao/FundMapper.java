package com.hello.dao;

import com.hello.model.pojo.Fund;

public interface FundMapper {
    int deleteByPrimaryKey(Integer fundId);

    int insert(Fund record);

    int insertSelective(Fund record);

    Fund selectByPrimaryKey(Integer fundId);

    int updateByPrimaryKeySelective(Fund record);

    int updateByPrimaryKey(Fund record);

    Fund getFundByUserId(int userId);
}