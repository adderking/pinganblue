package com.cele.pinganblue.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.Date;

/**
 * Author: kingcobra
 * create on 2024/3/31 16:25
 * 社会用户注册VO类
 **/
@Getter
@Setter
public class RegisterVO extends BaseVO{
    @Serial
    private static final long serialVersionUID = 3705604089380443983L;
    private String nickname;    //微信昵称
    private String username;    //真实姓名
    private String wechatID;    //用户的微信ID
    private StreetVO street;  //所属街道
    private String phoneNum; //电话号码
    private String idNo;    //身份证号码
}
