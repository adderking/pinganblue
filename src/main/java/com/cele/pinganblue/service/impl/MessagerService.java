package com.cele.pinganblue.service.impl;

import com.cele.pinganblue.common.EnumConstants;
import com.cele.pinganblue.dao.IMessagerDao;
import com.cele.pinganblue.mapper.MessagerMapper;
import com.cele.pinganblue.pojo.MessagerPO;
import com.cele.pinganblue.service.IMessagerService;
import com.cele.pinganblue.vo.MessagerVO;
import com.cele.pinganblue.vo.RegisterVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * Author: kingcobra
 * create on 2024/3/31 16:48
 **/
@Service("messagerService")
@Slf4j
public class MessagerService implements IMessagerService {
    @Autowired
    private MessagerMapper messagerMapper;

    @Autowired
    private IMessagerDao messagerDao;
    @Override
    public boolean signUp(RegisterVO registerVO) {
//        MessageDao.save();
        return false;
    }

    @Override
    public boolean updateMessager(MessagerVO messagerVO) throws Exception {
       MessagerPO messagePO =  messagerMapper.voConvertToPO(messagerVO);
       messagerDao.save(messagePO);
       return false;
    }

    @Override
    public boolean changeUserStatus(MessagerVO messageVO, EnumConstants.UserStatus userStatus) throws Exception {
        return false;
    }

    @Override
    public boolean deleteMessager(MessagerVO messageVO) throws Exception {
        return false;
    }

    @Override
    public MessagerVO findByWechatId(String weChatID) throws Exception {
        return null;
    }

    @Override
    public Page<MessagerVO> findByPage(int pageNum, int pageSize) {
        return null;
    }
}
