package com.hello.service;

import com.hello.model.pojo.Fund;

public interface FundService {

    public int insert(Fund fund);


    public Fund getFundByUserId(int userId);


    public int updateByPrimaryKey(Fund record);

    public boolean inputOfFund(Fund fund);
}
