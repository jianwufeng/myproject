package com.crm;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

    // 跨域域名设置
    public static final String[] ALLOW_DOMAIN_ARRAY = { "http://h5.guimiclub.net", "https://h5.guimiclub.net", "http://cms.guimiclub.net", "https://cms.guimiclub.net" };

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //log.info("{}执行跨域过滤器", System.currentTimeMillis());
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String originHeader = httpServletRequest.getHeader("Origin");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", originHeader);
        //        if ("dev".equals(System.getProperty("env"))) {
        //            httpServletResponse.setHeader("Access-Control-Allow-Origin", originHeader);
        //        } else {
        //            if (Arrays.asList(ALLOW_DOMAIN_ARRAY).contains(originHeader)) {
        //                httpServletResponse.setHeader("Access-Control-Allow-Origin", originHeader);
        //            }
        //        }
        httpServletResponse.setHeader("Access-Control-Request-Method", "OPTIONS,GET,POST,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers",
                "Origin,X-Requested-With,Content-Type,Accept,Referer,User-Agent,Authorization,X-Auth-Token,Cache-Control,If-Modified-Since");
        // 接收跨域的cookie
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");

        //跨域会发起一次put 一次post
        if ("OPTIONS".equals(httpServletRequest.getMethod())) {
            httpServletResponse.setHeader("Content-type", "text/html");
            httpServletResponse.getWriter().write("Options OK");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
