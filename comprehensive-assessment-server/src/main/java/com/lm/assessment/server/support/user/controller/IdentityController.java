package com.lm.assessment.server.support.user.controller;

import com.lm.assessment.common.response.RemoteResponse;
import com.lm.assessment.server.support.login.domain.UserSessionInfo;
import com.lm.assessment.server.support.user.vo.UserIdentityVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yond
 * @date 2023/10/21
 * @description 用户信息
 */
@RestController
public class IdentityController {


    @RequestMapping("identity")
    public RemoteResponse<UserIdentityVO> identity(UserSessionInfo userSessionInfo) {
        UserIdentityVO userIdentity = new UserIdentityVO();
        return RemoteResponse.success(userIdentity);
    }

}
