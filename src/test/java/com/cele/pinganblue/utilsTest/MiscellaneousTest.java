package com.cele.pinganblue.utilsTest;

import com.cele.pinganblue.common.EnumConstants;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Test
    public void testRegEx() {
        Pattern pattern = Pattern.compile("1[3-9]\\d{9}");
        String phoneNum = "132323233223";
        Matcher match = pattern.matcher(phoneNum);
        System.out.println(match.matches());
    }

    @Test
    public void testUserStatusEnum() {
        String status = "audit";
        EnumConstants.UserStatus userStatus = EnumConstants.UserStatus.valueOf(status);
        System.out.println(userStatus);
    }
}
