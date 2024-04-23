package com.cele.pinganblue.controllerTest;

import com.alibaba.fastjson2.JSON;
import com.cele.pinganblue.controller.MessagerController;
import com.cele.pinganblue.controller.MessagerOpenAPI;
import com.cele.pinganblue.vo.RegisterVO;
import com.cele.pinganblue.vo.StreetVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Author: kingcobra
 * create on 2024/4/23 09:58
 **/
public class MessagerControllerTest implements BaseControllerTest {
    @Autowired
    private MessagerController messagerController;

    @Autowired
    private MessagerOpenAPI messagerOpenAPI;

    private String API_URL_PREFIX = "/api/v1/messager";
    private String OPENAPI_URL_PREFIX = "/openapi/v1/messager";

    @Test
    public void signUpTest() {
        RegisterVO registerVO = new RegisterVO();
        StreetVO streetVO = new StreetVO();
        streetVO.setPrimaryKey("08b05a3f-dde9-4bd1-81cd-54a4d1622f94");
        streetVO.setStreetName("兴丰街道");
        streetVO.setStreetCode("110115001000");
        registerVO.setStreet(streetVO);
//        registerVO.setIdNo("110101201905010212");
        registerVO.setIdNo("11010120190501021");
        registerVO.setUsername("张三");
        registerVO.setNickname("弓长张");
        registerVO.setWechatID("we_id_111100001");
        registerVO.setPhoneNum("13410233022");
        String requestContent = JSON.toJSONString(registerVO);
        System.out.println(requestContent);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(messagerOpenAPI).build();
        try {
            MvcResult result = mockMvc.perform(post(OPENAPI_URL_PREFIX+"/signup1")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(requestContent))
                    .andReturn();
            String status = result.getResponse().getContentAsString();
            System.out.println(status);
            String errorMsg = result.getResolvedException().getMessage();
            System.out.println(errorMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
