package com.hello.dao;

import com.hello.model.pojo.MortgageCar;

public interface MortgageCarMapper {
    int deleteByPrimaryKey(Integer mortgageCarId);

    int insert(MortgageCar record);

    int insertSelective(MortgageCar record);

    MortgageCar selectByPrimaryKey(Integer mortgageCarId);

    int updateByPrimaryKeySelective(MortgageCar record);

    int updateByPrimaryKey(MortgageCar record);

    MortgageCar selectMortgageCarByUserId(int userId);
}