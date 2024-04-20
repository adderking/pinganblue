package com.cele.pinganblue.controller;

import com.cele.pinganblue.common.ResponseMessage;
import com.cele.pinganblue.service.IMessagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: kingcobra
 * create on 2024/4/17 11:02
 **/
@RestController
@RequestMapping("/openapi/v1/messager")
@Slf4j
public class MessagerOpenAPI implements BaseController{
    @Autowired
    private IMessagerService messagerService;

    @GetMapping(value = "/{weChatID}", produces = "application/json;charset=UTF-8")
    public ResponseMessage getByWeChatID(@PathVariable("weChatID") String id, @RequestBody String content) {
        System.out.println(id);
        System.out.println(content);
        return ResponseMessage.builder().build();
    }
}
