package com.cele.pinganblue.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Author: kingcobra
 * create on 2024/3/31 16:15
 * 社会用户注册后保存在互联网平台中的信息。
 **/
@Getter
@Setter
public class MessagerVO extends BaseVO{
    private String nickname;    //微信昵称
    private String wechatID;    //用户的微信ID
    private StreetVO street;  //所属街道
    private Integer userStatus; //用户审批状态,代码值参考UserStatus枚举类型
    private Date createTime; //用户创建时间

}
