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
}
