package com.cele.pinganblue.controllerTest;

import com.alibaba.fastjson2.JSON;
import com.cele.pinganblue.controller.StreetController;
import com.cele.pinganblue.vo.StreetVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Author: kingcobra
 * create on 2024/4/20 15:12
 **/
public class StreetControllerTest implements BaseControllerTest{
    @Autowired
    private StreetController streetController;

    private String URL_PREFIX = "/api/v1/street";

    @Test
    public void save() {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(streetController).build();
        StreetVO streetVO = new StreetVO();
        streetVO.setStreetName("兴丰街道");
        streetVO.setStreetCode("110115001000");
        String content = JSON.toJSONString(streetVO);
        try {
            MvcResult result = mockMvc.perform(post(URL_PREFIX+"/save")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(content))
                            .andReturn();
            String status = result.getResponse().getContentAsString();
            System.out.println(status);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    @Test
    public void update() {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(streetController).build();
        StreetVO streetVO = new StreetVO();
        streetVO.setPrimaryKey("08b05a3f-dde9-4bd1-81cd-54a4d1622f94");
        streetVO.setStreetName("兴丰街道1");
        streetVO.setStreetCode("110115001000");
        String content = JSON.toJSONString(streetVO);
        try {
            MvcResult result = mockMvc.perform(post(URL_PREFIX+"/update")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(content))
                    .andReturn();
            String status = result.getResponse().getContentAsString();
            System.out.println(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void findAll() {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(streetController).build();
        try {
            MvcResult result = mockMvc.perform(get(URL_PREFIX+"/all")
                    .param("pageNum","-1")
                    .param("pageSize","2"))
                    .andReturn();
            String status = result.getResponse().getContentAsString();
            System.out.println(status);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void findByPK() {
        String pK = "08b05a3f-dde9-4bd1-81cd-54a4d1622f94";
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(streetController).build();
        try {
            MvcResult result = mockMvc.perform(get(URL_PREFIX+"/"+pK))
                    .andReturn();
            String status = result.getResponse().getContentAsString();
            System.out.println(status);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
