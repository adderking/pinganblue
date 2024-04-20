package com.cele.pinganblue.utils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import javax.security.auth.DestroyFailedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

/**
 * Author: kingcobra
 * create on 2024/4/13 14:47
 **/
@Slf4j
public class FilterUtil {
    public static String decrypt(String body) throws Exception  {
        String data="";
        try {
            Optional<String> optional = Optional.of(body);
            if (optional.isPresent()) {
                data = AESUtils.decrypt(body);
            }
        } catch (Exception e) {
            log.error("decrypt request data failure! requestData:{}", body, e);
            throw new DestroyFailedException();
        }
        return data;
    }
    public static String getRequestBody(HttpServletRequest request) {
        try {
            BufferedReader reader = request.getReader();
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String body = sb.toString();
            return body;
        } catch (IOException e) {
            log.error("get request body failure!", e);
        }
        return null;
    }

    public static String getRequestHeader(HttpServletRequest request) {
        String userCode = request.getHeader("user_code");
        return userCode;
    }
}
