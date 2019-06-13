package com.hello.service;

import com.hello.model.pojo.MortgageHouse;

public interface MortgageHouseService {
    int deleteByPrimaryKey(Integer mortgageHouseId);

    int insert(MortgageHouse record);

    int insertSelective(MortgageHouse record);

    MortgageHouse selectByPrimaryKey(Integer mortgageHouseId);

    int updateByPrimaryKeySelective(MortgageHouse record);

    int updateByPrimaryKey(MortgageHouse record);

     boolean inputOfMortgageHouse(MortgageHouse record);
}