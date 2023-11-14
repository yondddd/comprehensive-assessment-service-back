package com.lm.assessment.server.support.gateway.filter;

import com.lm.assessment.server.support.gateway.exception.GatewayException;
import com.lm.assessment.server.support.gateway.util.WebFilterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@Order(1)
//@Component
//@WebFilter(urlPatterns = "/*", asyncSupported = true)
public class SpringGatewayFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(SpringGatewayFilter.class);

    @Autowired
    private List<GatewayFilter> filterList;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path=request.getServletPath();
        try {
            if(path.startsWith("/ping") || path.startsWith("/gateway")){
                //到本地
                filterChain.doFilter(servletRequest, servletResponse);
            }else{
                GatewayFilterChain chain = new GatewaySimpleFilterChain(filterList);
                chain.doGatewayFilter(request, response);
            }
        } catch (GatewayException e) {
            WebFilterUtil.returnFailedJson(response, e.getCode(), "{\"code\":\"0001\",\"msg\":\"" + e.getMessage() + "\"}");
        }
    }
}