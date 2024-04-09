package com.cele.pinganblue.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Author: kingcobra
 * create on 2024/3/31 16:15
 **/
@Getter
@Setter
public class MessagerVO extends BaseVO{
    private String nickname;    //微信昵称
    private String wechatID;    //用户的微信ID
    private String street;  //所属街道
    private Integer userStatus;
    private Date createTime;
}
