package com.lm.assessment.server.support.gateway.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yond
 * @date 2023/10/22
 * @description
 */
public interface GatewayFilterChain extends FilterChain {

    void doGatewayFilter(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

    @Override
    default void doFilter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException {
        this.doGatewayFilter((HttpServletRequest) servletRequest,  (HttpServletResponse) servletResponse);
    }

}
