package com.cele.pinganblue.springConfig;


import com.cele.pinganblue.common.Constants;
import com.cele.pinganblue.exception.DecryptFailureException;
import com.cele.pinganblue.utils.FilterUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

/**
 * Author: kingcobra
 * create on 2024/4/13 11:33
 **/
//@Order(0)
//@WebFilter(urlPatterns = "/openapi/v1/*",filterName = "AESFilter",initParams = @WebInitParam(name = "noFilter",value="/openapi/v1/fileUpload"))
@Slf4j
public class AESFilter implements Filter {
    private String[] noFilterUrl;
//    private FilterUtil filterUtil;
    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        boolean isFlag = isNOFilter(httpServletRequest);
        if (isFlag) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            String requestBody = FilterUtil.getRequestBody(httpServletRequest);
            try {
                String data = FilterUtil.decrypt(requestBody);
                Optional<String> dataOptional = Optional.of(data);
                dataOptional.ifPresentOrElse(d -> {
                    String contentType ="application/json;";
                    AESRequestWrapper aesRequestWrapper = new AESRequestWrapper(httpServletRequest, d);
                    aesRequestWrapper.setAttribute("content-type", contentType);
                    try {
                        filterChain.doFilter(aesRequestWrapper, servletResponse);
                    } catch (IOException e) {
                        log.error("filter running Exception！", e);
                        throw new RuntimeException(e);
                    } catch (ServletException e) {
                        throw new RuntimeException(e);
                    }
                }, () -> {
                    try {
                        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
                        httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN,"请求数据为空");
                    } catch (IOException e) {
                        log.error("filter response Exception！", e);
                        throw new RuntimeException(e);
                    }
                });
            } catch (Exception e) {
                try {
                    log.error("request content decrypt failure!{}", requestBody, e);
                    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
                    httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN,"请求数据解密失败");
                } catch (IOException ioe) {
                    log.error("filter response Exception！", e);
                    throw new RuntimeException(e);
                }
              }
        }
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String initParam =  filterConfig.getInitParameter("noFilter");
        if(StringUtils.isNotEmpty(initParam)) {
            noFilterUrl = initParam.split(",");
        }
    }

    private boolean isNOFilter(HttpServletRequest request) {
        String uri = request.getRequestURI();
        boolean isContained = false;
        for (String s : noFilterUrl) {
            isContained |= uri.contains(s);
        }
        return isContained;
    }
}
