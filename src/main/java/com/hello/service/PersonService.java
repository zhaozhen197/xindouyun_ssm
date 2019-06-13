package com.hello.service;

import com.hello.model.pojo.Person;

public interface PersonService  {

    public int insert(Person person);


    public Person getPersonByUserId(int userId);


    public int updateByPrimaryKey(Person record);

    public boolean inputOfPerson(Person Person);
}
