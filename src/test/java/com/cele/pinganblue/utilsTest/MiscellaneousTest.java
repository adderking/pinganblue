package com.cele.pinganblue.utilsTest;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * Author: kingcobra
 * create on 2024/4/9 18:50
 **/
public class MiscellaneousTest {
    @Test
    public void testUUID() {
        UUID uID = UUID.randomUUID();
        System.out.println(uID.toString());
    }

    @Test
    public void testSwitch() {
        Integer code =99;
        String status =null;
        switch (code) {
            case 0-> { status = "unaudit";}
            case 1-> { status = "init";}
            case 2-> { status = "audit";}
            case 3-> { status = "disable";}
        }
        System.out.println(status);
    }
}
