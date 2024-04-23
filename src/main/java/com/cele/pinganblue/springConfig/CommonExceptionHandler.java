package com.cele.pinganblue.springConfig;

import com.cele.pinganblue.common.EnumConstants;
import com.cele.pinganblue.common.ResponseMessage;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author: kingcobra
 * create on 2024/4/23 16:32
 * 全局异常处理类
 * 通过AOP的方式切入，主要用于处理Spring validation 参数校验的异常信息，
 * 将其转换成可读性高的，便于前端展示的信息。
 **/
@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseMessage handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ResponseMessage.ResponseMessageBuilder builder = ResponseMessage.builder();
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder("校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getDefaultMessage()).append(", ");
        }
        String msg = sb.toString();
        return builder.status(EnumConstants.ResponseResult.failure).message(msg).build();
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseMessage handleConstraintViolationException(ConstraintViolationException ex) {
        ResponseMessage.ResponseMessageBuilder builder = ResponseMessage.builder();
        return builder.status(EnumConstants.ResponseResult.failure).message("参数校验失败:"+ex.getMessage()).build();
    }
}

