package com.cele.pinganblue.mappertest;

import com.alibaba.fastjson2.JSON;
import com.cele.pinganblue.mapper.MessagerMapper;
import com.cele.pinganblue.pojo.MessagerPO;
import com.cele.pinganblue.vo.MessagerVO;
import com.cele.pinganblue.vo.RegisterVO;
import com.cele.pinganblue.vo.StreetVO;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * Author: kingcobra
 * create on 2024/3/31 17:38
 **/
public class MessagerMapperTest {

    @Test
    public void MessagerVoToPO() {
        MessagerVO messagerVO = new MessagerVO();
        messagerVO.setNickname("nick");
        StreetVO streetVO = new StreetVO();
        streetVO.setStreetCode("01");
        streetVO.setStreetName("清源路街道");
        messagerVO.setStreet(streetVO);
        messagerVO.setWechatID("weChatID_1");
        messagerVO.setPrimaryKey(UUID.randomUUID().toString());
        MessagerPO messagerPO = MessagerMapper.INSTANCE.voConvertToPO(messagerVO);
        String data = JSON.toJSONString(messagerPO);
        System.out.println(data);
    }

    @Test
    public void RegisterVOToPO() {
        RegisterVO registerVO = new RegisterVO();
        registerVO.setIdNo("912391293912");
        registerVO.setUsername("张三");
        registerVO.setPhoneNum("1234231233");
        registerVO.setNickname("佚名");
        registerVO.setWechatID("1-1");
        StreetVO streetVO = new StreetVO();
        streetVO.setStreetCode("01");
        streetVO.setStreetName("清源路街道");
        registerVO.setStreet(streetVO);
        MessagerPO messagerPO = MessagerMapper.INSTANCE.registerVOToPO(registerVO);
        String data = JSON.toJSONString(messagerPO);
        System.out.println(data);
    }
}
