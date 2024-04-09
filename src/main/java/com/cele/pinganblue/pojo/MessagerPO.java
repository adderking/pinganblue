package com.cele.pinganblue.pojo;

import com.cele.pinganblue.common.EnumConstants.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.util.Date;

/**
 * Author: kingcobra
 * create on 2024/3/31 15:18
 * 信息员PO
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "t_messager")
public class MessagerPO extends BasePO{
    @Serial
    private static final long serialVersionUID = -4089797676454486023L;
    @Column(name = "nickname")
    private String nickname;    //微信昵称
    @Column(name = "username")
    private String username;    //真实姓名
    @Column(name="wechatid")
    private String wechatID;    //用户的微信ID
    @Column(name="street")
    private String street;  //所属街道
    @Column(name="phonenum")
    private String phoneNum; //电话号码
    @Column(name = "creattime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;    //注册时间
    @Column(name = "userstatus")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
}
