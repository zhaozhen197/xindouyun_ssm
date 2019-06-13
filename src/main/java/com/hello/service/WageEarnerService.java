package com.hello.service;

import com.hello.model.pojo.WageEarner;

public interface WageEarnerService {

    public int insert(WageEarner wageEarner);


    public WageEarner getWageEarnerByUserId(int userId);


    public int updateByPrimaryKey(WageEarner record);

    public boolean inputOfWageEarner(WageEarner wageEarner);

}
