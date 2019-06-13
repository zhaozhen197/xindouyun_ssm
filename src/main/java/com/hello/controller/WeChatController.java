package com.hello.controller;

import com.hello.model.CheckWechatServer;
import com.hello.service.WeChatService;
import com.hello.util.SignUtil;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by zane on 2017/1/19.
 */
@Controller
@RequestMapping("/wechat")
public class WeChatController {

    @Resource
    private WeChatService weChatService;

    /**
     * 确认请求来自微信服务器
     */
    @RequestMapping(value = "/CheckRequest", method = RequestMethod.GET)
    public @ResponseBody
    String CheckRequest(CheckWechatServer checkRequest) {
        System.out.println(checkRequest.toString());
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(checkRequest.getSignature(), checkRequest.getTimestamp(), checkRequest.getNonce())) {
            return checkRequest.getEchostr();
        }
        return "";
    }

//    @RequestMapping(value = "/CheckRequest", method = RequestMethod.POST)
//    public @ResponseBody
//    String getTuiSong(CheckWechatServer checkRequest, HttpServletRequest request) throws IOException, DocumentException {
//        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
////        if (SignUtil.checkSignature(checkRequest.getSignature(), checkRequest.getTimestamp(), checkRequest.getNonce())) {
////            String respXml = weChatService.dealWithUserOper(request);
////            return respXml;
////        }
//        return "";
//    }
}
