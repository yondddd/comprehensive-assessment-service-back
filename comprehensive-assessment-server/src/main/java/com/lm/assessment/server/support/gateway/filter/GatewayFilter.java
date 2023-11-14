package com.lm.assessment.server.support.gateway.filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface GatewayFilter {
    public void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse, GatewayFilterChain filterChain) throws IOException, ServletException;
}