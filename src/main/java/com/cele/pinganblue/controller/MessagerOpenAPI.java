package com.cele.pinganblue.controller;

import com.cele.pinganblue.common.EnumConstants;
import com.cele.pinganblue.common.ResponseMessage;
import com.cele.pinganblue.service.IMessagerService;
import com.cele.pinganblue.vo.RegisterVO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Author: kingcobra
 * create on 2024/4/17 11:02
 **/
@RestController
@RequestMapping("/openapi/v1/messager")
@Slf4j
public class MessagerOpenAPI implements BaseController {
    @Autowired
    private IMessagerService messagerService;

    @GetMapping(value = "/{weChatID}", produces = "application/json;charset=UTF-8")
    public ResponseMessage getByWeChatID(@PathVariable("weChatID") String id, @RequestBody String content) {
        System.out.println(id);
        System.out.println(content);
        return ResponseMessage.builder().build();
    }
    @PostMapping(value = "/signup", produces = "application/json;charset=utf-8")
    public ResponseMessage signUp(@RequestBody @Validated RegisterVO registerVO) {
        ResponseMessage.ResponseMessageBuilder builder = ResponseMessage.builder();
        try {
            messagerService.signUp(registerVO);
            return builder.status(EnumConstants.ResponseResult.success).build();
        } catch (Exception e) {
            return builder.status(EnumConstants.ResponseResult.failure).message(e.getMessage()).build();
        }
    }
}
