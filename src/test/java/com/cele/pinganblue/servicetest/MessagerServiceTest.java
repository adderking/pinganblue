package com.cele.pinganblue.servicetest;

import com.cele.pinganblue.PinganblueApplicationTests;
import com.cele.pinganblue.service.IMessagerService;
import com.cele.pinganblue.vo.MessagerVO;
import com.cele.pinganblue.vo.StreetVO;
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
        StreetVO streetVO = new StreetVO();
        streetVO.setPrimaryKey(UUID.randomUUID().toString());
        streetVO.setStreetCode("01");
        streetVO.setStreetName("清源路街道");
        messagerVO.setStreet(streetVO);
        messagerVO.setWechatID("weChatID_1");
//        messagerVO.setPrimaryKey(UUID.randomUUID().toString());
        try {
            boolean status = messagerService.updateMessager(messagerVO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
