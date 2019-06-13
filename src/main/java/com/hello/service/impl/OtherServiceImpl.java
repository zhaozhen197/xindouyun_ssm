package com.hello.service.impl;

import com.hello.dao.OtherMapper;
import com.hello.model.pojo.Other;
import com.hello.service.OtherService;
import com.hello.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author zane
 */
@Service("otherService")
public class OtherServiceImpl implements OtherService {

    @Autowired
    private OtherMapper otherMapper;
    @Override
    public int insert(Other other) {
        return otherMapper.insert(other);
    }

    @Override
    public Other getOtherByUserId(int userId) {
        return otherMapper.getOtherByUserId(userId);
    }

    @Override
    public int updateByPrimaryKey(Other record) {
        return otherMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean inputOfOther(Other other) {
        Other oldOther = otherMapper.getOtherByUserId(other.getUserId());
        int flag1 = 0;
        int flag2 = 0;

        other.setUpdateTime(Util.getNowDateTime());
        if (oldOther != null) {
            other.setOtherId(oldOther.getOtherId());
            flag1 = otherMapper.updateByPrimaryKeySelective(other);
        }else {
            other.setCreationTime(Util.getNowDateTime());
            flag2 =  otherMapper.insert(other);
        }

        if (flag1 == 1 || flag2 == 1) {
            return true;
        }
        return false;
    }
}
