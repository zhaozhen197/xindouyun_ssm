package com.hello.service;

import com.hello.model.pojo.MortgageCar;
import com.hello.model.pojo.MortgageHouse;

public interface MortgageCarService {
    int deleteByPrimaryKey(Integer mortgageCarId);

    int insert(MortgageCar record);

    int insertSelective(MortgageCar record);

    MortgageCar selectByPrimaryKey(Integer mortgageCarId);

    int updateByPrimaryKeySelective(MortgageCar record);

    int updateByPrimaryKey(MortgageCar record);

    boolean inputOfMortgageCar(MortgageCar mortgageCar);
}