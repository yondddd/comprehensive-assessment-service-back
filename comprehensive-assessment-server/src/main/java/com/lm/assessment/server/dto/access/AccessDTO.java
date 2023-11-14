package com.lm.assessment.server.dto.access;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yond
 * @date 2023/10/21
 * @description 权限
 */
@ApiModel("权限")
public class AccessDTO {

    @ApiModelProperty("权限id")
    private Integer accessId;
    @ApiModelProperty("权限名称")
    private String accessName;
    @ApiModelProperty("权限code")
    private String accessCode;

    public Integer getAccessId() {
        return accessId;
    }

    public void setAccessId(Integer accessId) {
        this.accessId = accessId;
    }

    public String getAccessName() {
        return accessName;
    }

    public void setAccessName(String accessName) {
        this.accessName = accessName;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    @Override
    public String toString() {
        return "AccessDTO{" +
                "accessId=" + accessId +
                ", accessName='" + accessName + '\'' +
                ", accessCode='" + accessCode + '\'' +
                '}';
    }
}
