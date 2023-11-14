package com.lm.assessment.server.support.login.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author yond
 * @date 2023/10/21
 * @description 用户登录信息
 */
@ApiModel("用户登录信息")
public class UserSessionInfo implements Serializable {

    private static final long serialVersionUID = 5034327639068580183L;

    @ApiModelProperty("单位id")
    private Integer orgId;
    @ApiModelProperty("用户id")
    private Long userId;
    @ApiModelProperty("guid")
    private String guid;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public String toString() {
        return "UserSessionInfo{" +
                "orgId=" + orgId +
                ", userId=" + userId +
                ", guid='" + guid + '\'' +
                '}';
    }
}
