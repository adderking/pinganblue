package com.cele.pinganblue.exception;

import com.cele.pinganblue.common.Constants;

/**
 * Author: kingcobra
 * create on 2024/4/13 14:54
 **/
public class DecryptFailureException extends RuntimeException{

    public DecryptFailureException() {
        super();
    }

    public DecryptFailureException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return Constants.DECRYPT_FAILURE_MESSAGE;
    }
}
