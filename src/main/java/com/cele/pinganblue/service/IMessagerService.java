package com.cele.pinganblue.service;

import com.cele.pinganblue.vo.MessagerVO;
import com.cele.pinganblue.vo.RegisterVO;

/**
 * Author: kingcobra
 * create on 2024/3/31 16:14
 **/

public interface IMessagerService {

    public boolean signUp(RegisterVO registerVO);
    public boolean updateMessage(MessagerVO messagerVO);

}
