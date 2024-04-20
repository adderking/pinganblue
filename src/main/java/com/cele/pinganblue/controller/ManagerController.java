package com.cele.pinganblue.controller;

import com.cele.pinganblue.common.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: kingcobra
 * create on 2024/4/17 15:55
 **/
@RestController
@RequestMapping("/api/v1/manager")
@Slf4j
public class ManagerController {

    @PostMapping(value = "/save", produces = "application/json;charset=utf-8")
    public ResponseMessage saveManager(String id) {
        return ResponseMessage.builder().data("success!").build();
    }
}
