package com.cele.pinganblue.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serial;

/**
 * Author: kingcobra
 * create on 2024/3/30 11:10
 * 互联网管理平台 管理员PO
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "t_manager")
public class ManagerPO extends BasePO{
    @Serial
    private static final long serialVersionUID = 3976689970160196986L;
    @Column(name="username")
    private String username;
    @Column(name = "psw")
    private String password;
}
