package com.cele.pinganblue.springConfig;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Author: kingcobra
 * create on 2024/4/13 15:30
 **/
@Slf4j
public class AESRequestWrapper extends HttpServletRequestWrapper {

    private HttpServletRequest request;
    private String requestBody;

    private final Map<String, String> requestHeaders = new HashMap<>();
    public AESRequestWrapper(HttpServletRequest request) {
        super(request);
    }
    public AESRequestWrapper(HttpServletRequest request, String requestBody) {
        super(request);
        this.request = request;
        this.requestBody = requestBody;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    public void addHeader(String key, String value) {
        requestHeaders.put(key, value);
    }
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(requestBody.getBytes(request.getCharacterEncoding()));
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }
            @Override
            public int read() throws IOException {
                return inputStream.read();
            }
        };
    }

    @Override
    public String getHeader(String name) {
        String headerValue = super.getHeader(name);
        if (requestHeaders.containsKey(name)) {
            headerValue = requestHeaders.get(name);
        }
        return headerValue;
    }
    /**
     * 得到headers的名称
     */
    @Override
    public Enumeration<String> getHeaderNames() {
        List<String> names = Collections.list(super.getHeaderNames());
        for (String name : requestHeaders.keySet()) {
            names.add(name);
        }
        return Collections.enumeration(names);
    }
    @Override
    public Enumeration<String> getHeaders(String name) {
        List<String> values = Collections.list(super.getHeaders(name));
        if (requestHeaders.containsKey(name)) {
            log.info("getHeaders --->{}", requestHeaders.get(name));
            values = Arrays.asList(requestHeaders.get(name));
        }
        return Collections.enumeration(values);
    }

    @Override
    public String getContentType() {
        return super.getContentType();
    }

}
