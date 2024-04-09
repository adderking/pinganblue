package com.cele.pinganblue.springConfig;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.annotation.Order;

import java.io.IOException;

/**
 * Author: kingcobra
 * create on 2024/1/16 10:10
 **/

//@Order(1)
//@WebFilter(urlPatterns = "/*",filterName = "loginFilter",initParams = @WebInitParam(name = "noFilter",value="/login,/auth,/logout"))
public class LoginFilter implements Filter {

    private String[] noFilterUrl;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        boolean isFlag = isNOFilter(httpServletRequest);
        if (isFlag) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            HttpSession session =  httpServletRequest.getSession();
            Object logonUser = session.getAttribute("logonUser");
            if (logonUser == null) {
                httpServletRequest.getRequestDispatcher("/login").forward(servletRequest, servletResponse);
            }else {
                filterChain.doFilter(servletRequest, servletResponse);
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
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
