package com.cele.pinganblue.service;

import com.cele.pinganblue.common.EnumConstants;
import com.cele.pinganblue.vo.MessagerVO;
import com.cele.pinganblue.vo.RegisterVO;
import org.springframework.data.domain.Page;

/**
 * Author: kingcobra
 * create on 2024/3/31 16:14
 **/

public interface IMessagerService {

    /**
     * 信息员注册
     * @param registerVO
     * @return
     * @throws Exception
     */
    public boolean signUp(RegisterVO registerVO) throws Exception ;

    /**
     * 信息员更新
     * @param messagerVO
     * @return
     * @throws Exception
     */
    public boolean updateMessager(MessagerVO messagerVO) throws Exception ;

    /**
     * 修改信息员装填
     * @param messageVO
     * @param userStatus
     * @return
     * @throws Exception
     */

    public boolean changeUserStatus(MessagerVO messageVO, EnumConstants.UserStatus userStatus) throws Exception ;

    /**
     * 删除信息员
     * @param messageVO
     * @return
     * @throws Exception
     */

    public boolean deleteMessager(MessagerVO messageVO) throws Exception ;

    /**
     * 根据微信ID查找信息员
     * @param weChatID
     * @return
     * @throws Exception
     */

    public MessagerVO findByWechatId(String weChatID) throws Exception ;

    public Page<MessagerVO> findByPage(int pageNum, int pageSize);

}
