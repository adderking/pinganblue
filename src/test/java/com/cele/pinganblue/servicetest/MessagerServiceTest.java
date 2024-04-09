package com.cele.pinganblue.servicetest;

import com.cele.pinganblue.PinganblueApplicationTests;
import com.cele.pinganblue.service.IMessagerService;
import com.cele.pinganblue.vo.MessagerVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * Author: kingcobra
 * create on 2024/3/31 16:58
 **/
public class MessagerServiceTest extends PinganblueApplicationTests {

    @Autowired
    private IMessagerService messagerService;

    @Test
    public void updateMessagerTest() {
        MessagerVO messagerVO = new MessagerVO();
        messagerVO.setNickname("nick");
        messagerVO.setStreet("street1");
        messagerVO.setWechatID("weChatID_1");
        messagerVO.setPrimaryKey(UUID.randomUUID().toString());
        boolean status = messagerService.updateMessage(messagerVO);
    }


}
