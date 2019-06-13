package com.hello.service.impl;

import com.hello.dao.MortgageCarMapper;
import com.hello.model.pojo.MortgageCar;
import com.hello.service.MortgageCarService;
import com.hello.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mortgageCarService")
public class MortgageCarServiceImpl implements MortgageCarService {
    @Autowired
    private MortgageCarMapper mortgageCarMapper;
    @Override
    public int deleteByPrimaryKey(Integer mortgageCarId) {
        return mortgageCarMapper.deleteByPrimaryKey(mortgageCarId);
    }

    @Override
    public int insert(MortgageCar record) {
        return mortgageCarMapper.insert(record);
    }

    @Override
    public int insertSelective(MortgageCar record) {
        return mortgageCarMapper.insertSelective(record);
    }

    @Override
    public MortgageCar selectByPrimaryKey(Integer mortgageCarId) {
        return mortgageCarMapper.selectByPrimaryKey(mortgageCarId);
    }

    @Override
    public int updateByPrimaryKeySelective(MortgageCar record) {
        return mortgageCarMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MortgageCar record) {
        return mortgageCarMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean inputOfMortgageCar(MortgageCar mortgageCar) {
        MortgageCar oldMortgageCar = mortgageCarMapper.selectMortgageCarByUserId(mortgageCar.getUserId());
        int flag1 = 0;
        int flag2 = 0;
        mortgageCar.setUpdateTime(Util.getNowDateTime());

        if (oldMortgageCar != null) {
            mortgageCar.setMortgageCarId(oldMortgageCar.getMortgageCarId());
            flag1 = mortgageCarMapper.updateByPrimaryKeySelective(mortgageCar);
        } else {
            mortgageCar.setCreateTime(Util.getNowDateTime());
            flag2 = mortgageCarMapper.insert(mortgageCar);
        }
        if (flag1 == 1 || flag2 == 1) {
            return true;
        }
        return false;
    }

}
