package com.lm.assessment.server.support.gateway.filter;

import com.lm.assessment.server.support.login.domain.UserSessionInfo;
import com.lm.assessment.server.support.login.jwt.JwtConstant;
import com.lm.assessment.server.support.login.jwt.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yond
 * @date 2023/10/22
 * @description 用户token信息
 */
@Order(2)
@Component
public class UserSessionFilter implements GatewayFilter {

    private String tokenHeader = "Authorization";

    @Override
    public void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse, GatewayFilterChain filterChain) throws IOException, ServletException {
        String header = servletRequest.getHeader(tokenHeader);
        Claims claims = JwtUtil.validateJwt(header, JwtConstant.DEFAULT_SECRET);
        String guid = claims.getSubject();

        filterChain.doFilter(servletRequest, servletResponse);
    }

}
