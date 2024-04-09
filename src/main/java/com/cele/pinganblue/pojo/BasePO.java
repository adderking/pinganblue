package com.cele.pinganblue.pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

/**
 * Author: kingcobra
 * create on 2024/3/30 14:02
 **/
@Getter
@Setter
@MappedSuperclass
public class BasePO implements Serializable {

    @Id
    @Column(name ="primarykey")
    protected UUID primaryKey;

    public BasePO() {
    }
}
