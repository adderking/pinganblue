package com.cele.pinganblue.utils;

import com.cele.pinganblue.exception.DecryptFailureException;
import com.cele.pinganblue.exception.EncryptFailureException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author kingcobra
 * @Date 2024-03-31
 * AES加解密
 * 加密的字符串使用Base64进行编码
 * 解密前先用Base64解码，再解密
 */
@Slf4j
public class AESUtils {

    private static final String AES_KEY = "DXgonGAn98AF32Qe";
    private static final String AES_IV = "DXgonGAn98AF32Qe";

    public static String encrypt(String data) throws Exception {
        String result = null;
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] plaintext = data.getBytes();
            SecretKeySpec keyspec = new SecretKeySpec(AES_KEY.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(AES_IV.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            result = Base64.encodeBase64String(encrypted);
        } catch (Exception e) {
            log.error("encrypt data {} failure!",data, e);
            throw new EncryptFailureException();
        } finally{
            return result;
        }
    }

    public static String decrypt(String data) throws Exception {
        String result = null;
        try {
            byte[] encrypted1 = Base64.decodeBase64(data);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keyspec = new SecretKeySpec(AES_KEY.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(AES_IV.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            result =  originalString.trim();
        } catch (Exception e) {
            log.error("descrypt data {} failure!",data, e);
            throw new DecryptFailureException();
        }
        return result;
    }

}
