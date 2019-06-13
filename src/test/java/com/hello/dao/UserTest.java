package com.hello.dao;


import com.hello.model.pojo.User;
import com.hello.service.MessageService;
import com.hello.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-*.xml"})
public class UserTest {

    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;

    @Test
    public void testUserInser() {
        User user = new User();
        user.setName1("赵先生");
        user.setPhone("15090109700");
        userService.insertUser(user);
    }
}
