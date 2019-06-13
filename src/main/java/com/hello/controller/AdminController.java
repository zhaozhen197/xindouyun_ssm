package com.hello.controller;


import com.hello.model.pojo.User;
import com.hello.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private WageEarnerService wageEarnerService;

    @Autowired
    private PersonService personService;

    @Autowired
    private OtherService otherService;

    @Autowired
    private BusinessOwnerService businessOwnerService;

    @Autowired
    private FundService fundService;


    @RequestMapping("/userList")
    public String toLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> userList = new ArrayList<>();
        userList  = userService.selectAllUser();
        request.setAttribute("userList", userList);
        return "admin/userlist";
    }

}
