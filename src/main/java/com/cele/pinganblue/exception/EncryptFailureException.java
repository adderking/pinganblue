package com.cele.pinganblue.exception;

import com.cele.pinganblue.common.Constants;

/**
 * Author: kingcobra
 * create on 2024/4/13 14:54
 **/
public class EncryptFailureException extends RuntimeException{

    public EncryptFailureException() {
        super();
    }

    public EncryptFailureException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return Constants.ENCRYPT_FAILURE_MESSAGE;
    }
}
