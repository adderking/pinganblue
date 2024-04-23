package com.cele.pinganblue.utilsTest;


import com.cele.pinganblue.exception.DecryptFailureException;
import com.cele.pinganblue.utils.AESUtils;
import com.cele.pinganblue.utils.DesUtil2;
import org.junit.jupiter.api.Test;

import javax.security.auth.DestroyFailedException;

/**
 * Author: kingcobra
 * create on 2024/3/30 15:07
 * 一期系统加解密功能测试
 * 一期采用DES加密，使用DesUtil2类进行加解密，Key为用户编码（userCode)
 **/
public class EncryptTest {

    /**
     * 测试一期的DES解密
     */
    @Test
    public void decryptTest() {
        String encryptString = "8msleqnOVhzKlvGw/x76tjfiKNhd8jwobLg0r/HFyi3ofa1iydKNK/EQaIfMCGLax4iOK7B3xe7ggFsOj44iqd4xVE+SCC6GyC4THA7J37I=";
        String userCode = "20180820";
        try {
           String content = DesUtil2.decrypt(encryptString,userCode);
            System.out.println(content);
        } catch (Exception e) {
//            throw new RuntimeException(e);
            throw new DecryptFailureException();
        }

    }

    @Test
    public void testException() {
        try {
            throwException();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
    }
    private void throwException() throws Exception {
        throw new DecryptFailureException();
    }
    /**
     * 测试本期AES加密
     */
    @Test
    public void encryptTest() {
//        String content = "刘磊"; // 一期的加密串 z2iXmjSRLrpoWER+u6adog==; 本期加密串为：uGNlg1gYpFVSKGDiiL/p3w==。
//        String content = "{\"user_code\":\"20180820\",\"pageNo\":\"1\",\"pageSize\":\"20\",\"keyword\":\"加大\"}";
//        String content = "{\"content\":\"web.filter.CharacterEncoding\"}";
        String content = "{\n" +
                "  \"idNo\": \"11010120190501021\",\n" +
                "  \"nickname\": \"弓长张\",\n" +
                "  \"phoneNum\": \"13410233022\",\n" +
                "  \"street\": {\n" +
                "    \"primaryKey\": \"08b05a3f-dde9-4bd1-81cd-54a4d1622f94\",\n" +
                "    \"streetCode\": \"110115001000\",\n" +
                "    \"streetName\": \"兴丰街道\"\n" +
                "  },\n" +
                "  \"username\": \"张三\",\n" +
                "  \"wechatID\": \"we_id_111100001\"\n" +
                "}";
        try {
            String encrypt_content = AESUtils.encrypt(content);
            System.out.println(encrypt_content);
            String decrypt_content = AESUtils.decrypt(encrypt_content);
            System.out.println(decrypt_content);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }
}
