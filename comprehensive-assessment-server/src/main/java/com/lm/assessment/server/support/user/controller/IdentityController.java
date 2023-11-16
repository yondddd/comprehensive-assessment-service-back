package com.lm.assessment.server.support.user.controller;

import com.lm.assessment.common.response.RemoteResponse;
import com.lm.assessment.server.support.login.domain.UserSessionInfo;
import com.lm.assessment.server.support.user.vo.UserIdentityVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author yond
 * @date 2023/10/21
 * @description 用户信息
 */
@RestController
@RequestMapping("user")
public class IdentityController {

    @RequestMapping("identity")
    public RemoteResponse<UserIdentityVO> identity(@RequestBody UserSessionInfo userSessionInfo) {
        UserIdentityVO userIdentity = new UserIdentityVO();
        userIdentity.setUsername("张三");
        userIdentity.setRoles(Collections.singletonList("admin"));
        return RemoteResponse.success(userIdentity);
    }

}
