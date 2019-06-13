package com.hello.controller;

import com.alibaba.fastjson.JSONObject;

import com.hello.dao.MortgageCarMapper;
import com.hello.model.pojo.*;
import com.hello.service.*;
import com.hello.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * project helloSSM
 * authod 赵振
 * datetime 2017/11/23 16:16
 * desc
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MessageService messageService;
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

    @Autowired
    private FullPaymentHouseService fullPaymentHouseService;

    @Autowired
    private FullPaymentCarService fullPaymentCarService;

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private MortgageHouseService mortgageHouseService;

    @Autowired
    private MortgageCarService mortgageCarService;
//    private

    /**
     * 测试
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/showLogin")
    public String toLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "login";
    }

    @RequestMapping("/showInputInfo")
    public String toInputPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "inputInfo";
    }

    /**
     * 发送验证码
     */
    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String sendMessage(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String mobeil = request.getParameter("phoneNumber");
        ReturnMessage message = messageService.sendMsg(mobeil);
        String jsonString = JSONObject.toJSONString(message);
        jsonString = URLEncoder.encode(jsonString, "UTF-8");
        return jsonString;
    }


    /**
     * 用户进行登录                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   提交操作
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody
    String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String phoneNumber = request.getParameter("phoneNumber");
        String name1 = request.getParameter("name");
        String validateCode = request.getParameter("validateCode");
        String type = request.getParameter("type");
        //验证验证码是否正确
        ReturnMessage returnMessage = messageService.selectCodeByPhone(phoneNumber, validateCode);
        if ("Success".equals(returnMessage.getStatusCode())) {
            User user = new User();
            user.setName1(name1);
            user.setPhone(phoneNumber);
            user.setType(type);
            user.setCreateTime(Util.getNowDateTime());
            User oldUser = userService.selectUserByPhone(user.getPhone());
            if (oldUser != null) {
                user.setUserId(oldUser.getUserId());
                userService.updateByPrimaryKeySelective(user);
            } else {
                userService.insertUser(user);
            }
        }
        //返回登录结果
        String jsonString = JSONObject.toJSONString(returnMessage);
        return jsonString;
    }

    /**
     * 接收输入的表单数据
     *
     * @param user
     * @param businessOwner
     * @param person
     * @param wageEarner
     * @param other
     * @param fund
     * @return
     */
    @RequestMapping(value = "/inputInfo", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
//    @ResponseBody
    public String inputInfo(User user, BusinessOwner businessOwner, Person person, WageEarner wageEarner, Other other,
                            Fund fund, FullPaymentCar fullPaymentCar, FullPaymentHouse fullPaymentHouse,
                            MortgageCar mortgageCar, MortgageHouse mortgageHouse, Insurance insurance) {
        User oldUser = userService.selectUserByPhone(user.getPhone());
        boolean flagIdentity = false, flagFund = false;
        if (oldUser == null) {
            return "inputInfo";
        }
        user.setName1(oldUser.getName1());
        user.setUserId(oldUser.getUserId());
        user.setPhone(oldUser.getPhone());
        user.setType(oldUser.getType());
        user.setUpdateTime(Util.getNowDateTime());
        userService.updateUserByPK(user);

        switch (user.getIdentity()) {
            case "wage_earners":
                wageEarner.setUserId(user.getUserId());
                wageEarner.setUserphone(user.getPhone());

                flagIdentity = wageEarnerService.inputOfWageEarner(wageEarner);
                break;
            case "business_owner":
                businessOwner.setUserId(user.getUserId());
                businessOwner.setCreateTime(Util.getNowDateTime());
                businessOwner.setUserPhone(user.getPhone());
                flagIdentity = businessOwnerService.inputOfBusinessOwner(businessOwner);
                break;
            case "person":
                person.setUserId(user.getUserId());
                person.setCreateTime(Util.getNowDateTime());
                person.setUserPhone(user.getPhone());

                flagIdentity = personService.inputOfPerson(person);
                break;
            case "other":
                other.setUserId(user.getUserId());
                other.setCreationTime(Util.getNowDateTime());
                other.setUserPhone(user.getPhone());
                flagIdentity = otherService.inputOfOther(other);
                break;
            default:
                break;

        }
        //公积金
        if (1 == user.getFund()) {
            fund.setUserId(user.getUserId());
            fund.setUserPhone(user.getPhone());
            fund.setCreateTime(Util.getNowDateTime());
            flagFund = fundService.inputOfFund(fund);
        }

        //是否有房
        switch (user.getHouse()) {
            case "fullPaymentHouse":
                fullPaymentHouse.setUserId(user.getUserId());
                fullPaymentHouse.setUserPhone(user.getPhone());
                fullPaymentHouseService.inputOfFullPaymentHouse(fullPaymentHouse);
                break;
            case "mortgageHouse":
                mortgageHouse.setUserId(user.getUserId());
                mortgageHouse.setUserPhone(user.getPhone());
                mortgageHouseService.inputOfMortgageHouse(mortgageHouse);
                break;
            default:
                break;
        }


        //车
        switch (user.getCar()) {
            case "fullPaymentCar":
                fullPaymentCar.setUserId(user.getUserId());
                fullPaymentCar.setUserPhone(user.getPhone());
                fullPaymentCarService.inputOfFullPaymentCar(fullPaymentCar);
                break;
            case "mortgageCar":
                mortgageCar.setUserId(user.getUserId());
                mortgageCar.setUserPhone(user.getPhone());
                mortgageCarService.inputOfMortgageCar(mortgageCar);
                break;
            default:
                break;

        }
        //保险
        if ("1".equals(user.getInsurance())) {

            insurance.setUserId(user.getUserId());
            insurance.setUserPhone(user.getPhone());
            insuranceService.inputOfInsurance(insurance);
        }

//        ReturnMessage returnMessage= new ReturnMessage("Success","信息保存成功！");
//
//        if (!flagFund || !flagIdentity) {
//            returnMessage.setStatusCode("Error");
//            returnMessage.setMsg("信息保存失败请重试1");
//        }
//        String jsonString = JSONObject.toJSONString(returnMessage);

        if (!flagFund || !flagIdentity) {
            return "inputInfo";
        }
        return "login";
    }

}
