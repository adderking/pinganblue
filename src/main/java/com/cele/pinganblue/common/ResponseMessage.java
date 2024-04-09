package com.cele.pinganblue.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author: kingcobra
 * create on 2020/10/12 11:28
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseMessage<T> implements Serializable {

    private static final long serialVersionUID = 7904386918749920227L;
    private EnumConstants.ResponseResult status;
    private String message;
    private T data;

}
