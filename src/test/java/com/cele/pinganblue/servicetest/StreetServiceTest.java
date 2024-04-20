package com.cele.pinganblue.servicetest;

import com.cele.pinganblue.PinganblueApplicationTests;
import com.cele.pinganblue.service.IStreetService;
import com.cele.pinganblue.vo.StreetVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 * Author: kingcobra
 * create on 2024/4/20 15:46
 **/
public class StreetServiceTest extends PinganblueApplicationTests {
    @Autowired
    private IStreetService streetService;

    @Test
    public void findAll() {
        try {
            Page<StreetVO> streetVOS = streetService.findByPage(1, 2);
            System.out.println(streetVOS.getNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
