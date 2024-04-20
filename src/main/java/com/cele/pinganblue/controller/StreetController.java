package com.cele.pinganblue.controller;

import com.cele.pinganblue.common.EnumConstants.*;
import com.cele.pinganblue.common.ResponseMessage;
import com.cele.pinganblue.service.IStreetService;
import com.cele.pinganblue.vo.StreetVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Author: kingcobra
 * create on 2024/4/20 14:46
 **/

@RestController
@RequestMapping("/api/v1/street")
@Slf4j
public class StreetController implements BaseController{
    @Autowired
    private IStreetService streetService;
    private ResponseMessage.ResponseMessageBuilder responseMessageBuilder = ResponseMessage.builder();

    @PostMapping(value = "/save",produces = "application/json;charset=UTF-8")
    public ResponseMessage save(@RequestBody StreetVO streetVO) {
        try {
            streetService.add(streetVO);
            responseMessageBuilder.status(ResponseResult.success);
        } catch (Exception e) {
            responseMessageBuilder.status(ResponseResult.failure).message(e.getMessage());
        }
        return responseMessageBuilder.build();
    }
    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public ResponseMessage update(@RequestBody StreetVO streetVO) {
        try {
            streetService.updateStreet(streetVO);
            responseMessageBuilder.status(ResponseResult.success);
        } catch (Exception e) {
            responseMessageBuilder.status(ResponseResult.failure).message(e.getMessage());
        }
        return responseMessageBuilder.build();
    }
    @DeleteMapping(value = "/{pk}",produces = "application/json;charset=UTF-8")
    public ResponseMessage<StreetVO> delete(@PathVariable(value = "pk") String primaryKey) {
        try {
            StreetVO streetVO = streetService.findByStreetID(primaryKey);
            responseMessageBuilder.status(ResponseResult.success).data(streetVO);
        } catch (Exception e) {
            responseMessageBuilder.status(ResponseResult.failure).message(e.getMessage());
        }
        return responseMessageBuilder.build();
    }
    @GetMapping(value = "/{pk}",produces = "application/json;charset=UTF-8")
    public ResponseMessage<StreetVO> findStreetByPK(@PathVariable(value = "pk") String primaryKey) {
        try {
            StreetVO streetVO = streetService.findByStreetID(primaryKey);
            responseMessageBuilder.status(ResponseResult.success).data(streetVO);
        } catch (Exception e) {
            responseMessageBuilder.status(ResponseResult.failure).message(e.getMessage());
        }
        return responseMessageBuilder.build();
    }
    @GetMapping(value = "/all",produces = "application/json;charset=UTF-8")
    public ResponseMessage<Page<StreetVO>> findAll(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10")int pageSize) {
        try {
            Page<StreetVO> streetVOS = streetService.findByPage(pageNum,pageSize);
            responseMessageBuilder.status(ResponseResult.success).data(streetVOS);
        } catch (Exception e) {
            responseMessageBuilder.status(ResponseResult.failure).message(e.getMessage());
        }
        return responseMessageBuilder.build();
    }
}
