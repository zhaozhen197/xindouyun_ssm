package com.hello.dao;

import com.hello.model.pojo.MortgageHouse;

public interface MortgageHouseMapper {
    int deleteByPrimaryKey(Integer mortgageHouseId);

    int insert(MortgageHouse record);

    int insertSelective(MortgageHouse record);

    MortgageHouse selectByPrimaryKey(Integer mortgageHouseId);

    int updateByPrimaryKeySelective(MortgageHouse record);

    int updateByPrimaryKey(MortgageHouse record);

    MortgageHouse selectMortgageHouseByUserId(int userId);
}