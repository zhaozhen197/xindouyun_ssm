package com.hello.service.impl;

import com.hello.dao.FullPaymentCarMapper;
import com.hello.model.pojo.FullPaymentCar;
import com.hello.service.FullPaymentCarService;
import com.hello.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fullPaymentCarService")
public class FullPaymentCarServiceImpl implements FullPaymentCarService {
    @Autowired
    private FullPaymentCarMapper fullPaymentCarMapper;
    @Override
    public int deleteByPrimaryKey(Integer fullPaymentCarId) {
        return fullPaymentCarMapper.deleteByPrimaryKey(fullPaymentCarId);
    }

    @Override
    public int insert(FullPaymentCar record) {
        return fullPaymentCarMapper.insert(record);
    }

    @Override
    public int insertSelective(FullPaymentCar record) {
        return fullPaymentCarMapper.insertSelective(record);
    }

    @Override
    public FullPaymentCar selectByPrimaryKey(Integer fullPaymentCarId) {
        return fullPaymentCarMapper.selectByPrimaryKey(fullPaymentCarId);
    }

    @Override
    public int updateByPrimaryKeySelective(FullPaymentCar record) {
        return fullPaymentCarMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FullPaymentCar record) {
        return fullPaymentCarMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean inputOfFullPaymentCar(FullPaymentCar fullPaymentCar) {
        FullPaymentCar oldFullPaymentCar = fullPaymentCarMapper.selectFullPaymentCarByUserId(fullPaymentCar.getUserId());

        int flag1 = 0;
        int flag2 = 0;

        fullPaymentCar.setUpdateTime(Util.getNowDateTime());
        if (oldFullPaymentCar != null) {
            fullPaymentCar.setFullPaymentCarId(oldFullPaymentCar.getFullPaymentCarId());
            flag1 = fullPaymentCarMapper.updateByPrimaryKeySelective(fullPaymentCar);
        } else {
            fullPaymentCar.setCreateTime(Util.getNowDateTime());
            flag2 = fullPaymentCarMapper.insert(fullPaymentCar);
        }
        if (flag1 == 1 || flag2 == 1) {
            return true;
        }
        return false;
    }

}
