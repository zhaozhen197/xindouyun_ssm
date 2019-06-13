package com.hello.dao;


import com.hello.model.pojo.Message;
import com.hello.model.pojo.ReturnMessage;
import com.hello.service.MessageService;
import com.hello.util.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.ParseException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-*.xml"})
public class MessgaeMapperTest {
    @Autowired
    private MessageService messageService;
    @Autowired
    private MessageMapper messageMapper;
    @Test
    public void testInsert() throws ParseException {
        Message record = new Message();
        Byte usable = 0;
        Byte sended = 1;
        record.setPhone("15639068762");
        record.setSended(sended);
        record.setUsable(usable);
        record.setDeadLine((int) (System.currentTimeMillis() / 1000 + 10 * 60));
        record.setValidateCode(123456);

        record.setCreationDatetime(Util.getNowDateTime());
        record.setUpdateDatetime(Util.getNowDateTime());
        System.out.println(record);
        boolean flag = false;
//        if (messgaeMapper.insert(record) == 1) {
//            flag = true;
//        }
        assert flag;
    }

    @Test
    public void testUserInsert() {
        messageService.sendMsg("15090109700");
    }

    @Test
    public void testSelectMessages() {
        List<Message> messageList = messageMapper.selectCodeByPhone("15090109700");
        System.out.println(messageList.toString());

    }

    @Test
    public void selectCodeByPhoneTest() {

        ReturnMessage returnMessage = messageService.selectCodeByPhone("15090109700", "197795");
        System.out.println(returnMessage.toString());
    }


}

