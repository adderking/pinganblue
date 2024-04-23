package com.cele.pinganblue.service;

import com.cele.pinganblue.vo.MessagerVO;
import com.cele.pinganblue.vo.RegisterVO;
import org.springframework.data.domain.Page;

import java.util.Map;

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
    public void signUp(RegisterVO registerVO) throws Exception ;

    /**
     * 信息员更新
     * @param messagerVO
     * @return
     * @throws Exception
     */
    public void updateMessager(MessagerVO messagerVO) throws Exception ;

    /**
     * 修改信息员装填
     * @param messageVO
     * @param status 状态字符串 对应UserStatus枚举类型
     * @return
     * @throws Exception
     */

    public boolean changeUserStatus(MessagerVO messageVO, String status) throws Exception ;

    /**
     * 删除信息员
     * @param messageVO
     * @return
     * @throws Exception
     */

    public void deleteMessager(MessagerVO messageVO) throws Exception ;
    /**
     * 删除信息员
     * @param primaryKey 主键
     * @return
     * @throws Exception
     */
    public void deleteMessagerByPK(String primaryKey) throws Exception;

    public void deleteMessagerByStatus(String status) throws Exception;

    /**
     * 根据微信ID查找信息员
     * @param weChatID
     * @return
     * @throws Exception
     */

    public MessagerVO findByWechatId(String weChatID) throws Exception ;

    public Page<MessagerVO> findByPage(int pageNum, int pageSize);

    public Page<MessagerVO> findByStreet(String streetCode,int pageNum, int pageSize);

    public Page<MessagerVO> findByCondition(Map<String,Object> condition, int pageNum, int pageSize);

}
