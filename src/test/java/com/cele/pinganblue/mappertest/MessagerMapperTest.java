package com.cele.pinganblue.mappertest;

import com.cele.pinganblue.mapper.MessagerMapper;
import com.cele.pinganblue.pojo.MessagerPO;
import com.cele.pinganblue.vo.MessagerVO;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * Author: kingcobra
 * create on 2024/3/31 17:38
 **/
public class MessagerMapperTest {

    @Test
    public void voToPO() {
        MessagerVO messagerVO = new MessagerVO();
        messagerVO.setNickname("nick");
        messagerVO.setStreet("street1");
        messagerVO.setWechatID("weChatID_1");
        messagerVO.setPrimaryKey(UUID.randomUUID().toString());
        MessagerPO messagerPO = MessagerMapper.INSTANCE.voConvertToPO(messagerVO);
    }
}
