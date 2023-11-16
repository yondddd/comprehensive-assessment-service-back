package com.lm.assessment.server.support.user.vo;

import com.lm.assessment.server.dto.access.AccessDTO;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author yond
 * @date 2023/10/21
 * @description 当前登录用户信息
 */
public class UserIdentityVO implements Serializable {

    private static final long serialVersionUID = -5961740715716768457L;

    @ApiModelProperty("用户id")
    private Long userId;
    @ApiModelProperty("用户guid")
    private String guid;
    @ApiModelProperty("用户名称")
    private String username;
    @ApiModelProperty("手机")
    private String mobile;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("学号/工号")
    private String jobNumber;
    @ApiModelProperty("权限")
    private List<AccessDTO> access;
    @ApiModelProperty("单位id")
    private Integer orgId;

    @ApiModelProperty("角色")
    private List<String> roles;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public List<AccessDTO> getAccess() {
        return access;
    }

    public void setAccess(List<AccessDTO> access) {
        this.access = access;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserIdentityVO{" +
                "userId=" + userId +
                ", guid='" + guid + '\'' +
                ", username='" + username + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                ", access=" + access +
                ", orgId=" + orgId +
                ", roles=" + roles +
                '}';
    }
}
