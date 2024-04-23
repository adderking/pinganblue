package com.cele.pinganblue.vo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.io.Serial;

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
    @NotNull(message = "昵称不能为空")
    private String nickname;    //微信昵称
    private String username;    //真实姓名
    private String wechatID;    //用户的微信ID
    private StreetVO street;  //所属街道，街道代码
    @NotNull
    @Pattern(regexp = "1[3-9]\\d{9}",message = "电话号码格式错误")
    private String phoneNum; //电话号码
    @NotNull
    @Pattern(regexp = "[1-9]\\d{5}(19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[Xx\\d]",message = "证件号码格式错误")
    private String idNo;    //身份证号码

    @Override
    public String toString() {
        return "RegisterVO{" +
                "nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", wechatID='" + wechatID + '\'' +
                ", street=" + street +
                ", phoneNum='" + phoneNum + '\'' +
                ", idNo='" + idNo + '\'' +
                '}';
    }
}
