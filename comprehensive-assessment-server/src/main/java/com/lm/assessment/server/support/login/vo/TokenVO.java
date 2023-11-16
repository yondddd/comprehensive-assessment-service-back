package com.lm.assessment.server.support.login.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author yond
 * @date 2023/10/21
 * @description token
 */
public class TokenVO implements Serializable {

    private static final long serialVersionUID = 8406474009218062910L;

    @ApiModelProperty("登录token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenVO{" +
                "token='" + token + '\'' +
                '}';
    }
}
