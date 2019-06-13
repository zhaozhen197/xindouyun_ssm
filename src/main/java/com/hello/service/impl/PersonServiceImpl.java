package com.hello.service.impl;

import com.hello.dao.PersonMapper;
import com.hello.model.pojo.Person;
import com.hello.service.PersonService;
import com.hello.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personService")
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;
    @Override
    public int insert(Person person) {
        return personMapper.insert(person);
    }

    @Override
    public Person getPersonByUserId(int userId) {
        return personMapper.getPersonByUserId(userId);
    }

    @Override
    public int updateByPrimaryKey(Person record) {
        return personMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean inputOfPerson(Person person) {
        Person oldPerson = personMapper.getPersonByUserId(person.getUserId());
        int flag1 = 0;
        int flag2 = 0;

        person.setUpdateTime(Util.getNowDateTime());
        if (oldPerson != null) {
            person.setPersonId(oldPerson.getPersonId());
            flag1 = personMapper.updateByPrimaryKeySelective(person);
        }else {
            person.setCreateTime(Util.getNowDateTime());
            flag2 =  personMapper.insert(person);
        }
        if (flag1 == 1 || flag2 == 1) {
            return true;
        }
        return false;
    }
}
