package com.hello.service;

import com.hello.model.pojo.Other;

public interface OtherService {
    public int insert(Other other);


    public Other getOtherByUserId(int userId);


    public int updateByPrimaryKey(Other record);

    public boolean inputOfOther(Other Other);
}
