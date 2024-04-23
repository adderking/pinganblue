package com.cele.pinganblue.controller;

import com.cele.pinganblue.common.EnumConstants;
import com.cele.pinganblue.common.ResponseMessage;
import com.cele.pinganblue.service.IMessagerService;
import com.cele.pinganblue.vo.MessagerVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Author: kingcobra
 * create on 2024/4/20 17:44
 **/
@RestController
@Slf4j
@RequestMapping("/api/v1/messager")
public class MessagerController {
    @Autowired
    private IMessagerService messagerService;

    @DeleteMapping(value = "/{pk}", produces = "application/json;charset=UTF-8")
    public ResponseMessage deleteMessager(@PathVariable String pk) {
        ResponseMessage.ResponseMessageBuilder builder = ResponseMessage.builder();
        try {
            messagerService.deleteMessagerByPK(pk);
            return builder.status(EnumConstants.ResponseResult.success).build();
        } catch (Exception e) {
            return builder.status(EnumConstants.ResponseResult.failure).message(e.getMessage()).build();
        }
    }

    @DeleteMapping(value = "/condition", produces = "application/json;charset=UTF-8")
    public ResponseMessage deleteMessagerByCondition(String userStatus) {
        ResponseMessage.ResponseMessageBuilder builder = ResponseMessage.builder();
        try {
            messagerService.deleteMessagerByStatus(userStatus);
            return builder.status(EnumConstants.ResponseResult.success).build();
        } catch (Exception e) {
            return builder.status(EnumConstants.ResponseResult.failure).message(e.getMessage()).build();
        }
    }

    @GetMapping(value = "/all", produces = "application/json;charset=UTF-8")
    public ResponseMessage<Page<MessagerVO>> findAll(int pageNum,int pageSize){
        ResponseMessage.ResponseMessageBuilder builder = ResponseMessage.builder();
        try {
            Page<MessagerVO> messagerVOS = messagerService.findByPage(pageNum, pageSize);
            return builder.status(EnumConstants.ResponseResult.success).data(messagerVOS).build();
        } catch (Exception e) {
            return builder.status(EnumConstants.ResponseResult.failure).message(e.getMessage()).build();
        }
    }
    @GetMapping(value = "/byStreet", produces = "application/json;charset=UTF-8")
    public ResponseMessage<Page<MessagerVO>> findByStreet(String street,int pageNum,int pageSize){
        ResponseMessage.ResponseMessageBuilder builder = ResponseMessage.builder();
        try {
            Page<MessagerVO> messagerVOS = messagerService.findByStreet(street,pageNum, pageSize);
            return builder.status(EnumConstants.ResponseResult.success).data(messagerVOS).build();
        } catch (Exception e) {
            return builder.status(EnumConstants.ResponseResult.failure).message(e.getMessage()).build();
        }
    }
    @GetMapping(value = "/{weChatID}", produces = "application/json;charset=UTF-8")
    public ResponseMessage<MessagerVO> findByWechatID(@PathVariable String weChatID){
        ResponseMessage.ResponseMessageBuilder builder = ResponseMessage.builder();
        try {
            MessagerVO messagerVO = messagerService.findByWechatId(weChatID);
            return builder.status(EnumConstants.ResponseResult.success).data(messagerVO).build();
        } catch (Exception e) {
            return builder.status(EnumConstants.ResponseResult.failure).message(e.getMessage()).build();
        }
    }
    @GetMapping(value = "/condition", produces = "application/json;charset=UTF-8")
    public ResponseMessage<MessagerVO> findAllByCondition(@RequestBody Map<String,Object> condition,int pageNum,int pageSize){
        ResponseMessage.ResponseMessageBuilder builder = ResponseMessage.builder();
        try {
            Page<MessagerVO> messagerVOS = messagerService.findByCondition(condition,pageNum,pageSize);
            return builder.status(EnumConstants.ResponseResult.success).data(messagerVOS).build();
        } catch (Exception e) {
            return builder.status(EnumConstants.ResponseResult.failure).message(e.getMessage()).build();
        }
    }
}
