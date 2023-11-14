package com.lm.assessment.server.support.login.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author yond
 * @date 2023/10/22
 * @description 登录账户
 */
@ApiModel("登录账户")
public class LoginAccountVO implements Serializable {

    private static final long serialVersionUID = 1367931962259881559L;

    @ApiModelProperty("账户")
    private String account;
    @ApiModelProperty("账户类型")
    private Integer accountType;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("身份类型")
    private Integer identityType;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    @Override
    public String toString() {
        return "LoginAccountVO{" +
                "account='" + account + '\'' +
                ", accountType=" + accountType +
                ", password='" + password + '\'' +
                ", identityType=" + identityType +
                '}';
    }
}
