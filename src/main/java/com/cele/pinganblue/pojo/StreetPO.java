package com.cele.pinganblue.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

/**
 * Author: kingcobra
 * create on 2024/4/19 23:14
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="t_street")
public class StreetPO extends BasePO{
    private String streetName;  //街道名称
    private String streetCode; //街道代码
}
