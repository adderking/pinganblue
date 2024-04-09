package com.cele.pinganblue.service.impl;

import com.cele.pinganblue.mapper.MessagerMapper;
import com.cele.pinganblue.pojo.MessagerPO;
import com.cele.pinganblue.service.IMessagerService;
import com.cele.pinganblue.vo.MessagerVO;
import com.cele.pinganblue.vo.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: kingcobra
 * create on 2024/3/31 16:48
 **/
@Service("messagerService")
public class MessagerService implements IMessagerService {
    @Autowired
    private MessagerMapper messagerMapper;
    @Override
    public boolean signUp(RegisterVO registerVO) {
        return false;
    }

    @Override
    public boolean updateMessage(MessagerVO messagerVO) {
       MessagerPO messagePO =  messagerMapper.voConvertToPO(messagerVO);
       System.out.println(messagePO);
       return false;
    }
}
