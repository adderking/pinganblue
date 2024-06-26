package com.cele.pinganblue.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.SecureRandom;


public class DesUtil2 {
 
    private final static String DES = "DES";
 
    public static void main(String[] args) throws Exception {
    	for (int i = 1; i < 2; i++) {
    		String key = "userkey0";
    		System.err.println(encrypt("16389", key));//加密FU7J0K1fBLM=
    		System.err.println(decrypt(encrypt("161", key), key));//解密
    		System.err.println(decrypt("K96fP5wXLhA=", key));//解密
    		System.err.println(encrypt("12587", key));//加密FU7J0K1fBLM=
    		System.err.println(decrypt(encrypt("161", key), key));//解密
    		System.err.println(decrypt("K96fP5wXLhA=", key));//解密
    		System.err.println(encrypt("20175", key));//加密FU7J0K1fBLM=
    		System.err.println(decrypt(encrypt("30325", key), key));//解密
    		System.err.println(decrypt("80v704clcQXibtJ3FmZDAA==", key));//解密
		}
 
    }
     
    /**
     * Description 根据键值进行加密
     * @param data 
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    public static String encrypt(String data, String key) throws Exception {
        byte[] bt = encrypt(data.getBytes(), key.getBytes());
//        String strs = new BASE64Encoder().encode(bt);
        String strs = "";
        return strs;
    }
 
    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws IOException,
            Exception {
        if (data == null)
            return null;
//        BASE64Decoder decoder = new BASE64Decoder();
        Base64 decoder = new Base64();
        byte[] buf = decoder.decode(data);
        byte[] bt = decrypt(buf,key.getBytes("utf-8"));
//        byte[] bt = new byte[2];
        return new String(bt);
    }
 
    /**
     * Description 根据键值进行加密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
 
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
 
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
 
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);
 
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
 
        return cipher.doFinal(data);
    }
     
     
    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
 
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
 
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
 
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);
 
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
 
        return cipher.doFinal(data);
    }
}