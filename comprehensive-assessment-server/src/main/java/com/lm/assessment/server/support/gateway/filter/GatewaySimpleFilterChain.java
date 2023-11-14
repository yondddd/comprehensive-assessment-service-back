package com.lm.assessment.server.support.gateway.filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author yond
 * @date 2023/10/22
 * @description
 */
public class GatewaySimpleFilterChain implements GatewayFilterChain {

    private List<GatewayFilter> filters;

    public GatewaySimpleFilterChain(List<GatewayFilter> list) {
        this.filters = list;
    }

    private int pos = 0;

    @Override
    public void doGatewayFilter(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(pos<filters.size()){
            filters.get(pos++).doFilter(request, response, this);
        }
    }

}
