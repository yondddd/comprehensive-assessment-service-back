package com.lm.assessment.server.support.login.controller;

import com.lm.assessment.common.constant.RegexConstant;
import com.lm.assessment.common.response.RemoteResponse;
import com.lm.assessment.server.model.UserDO;
import com.lm.assessment.server.service.UserService;
import com.lm.assessment.server.support.login.domain.PayloadHelper;
import com.lm.assessment.server.support.login.jwt.JwtConstant;
import com.lm.assessment.server.support.login.jwt.JwtUtil;
import com.lm.assessment.server.support.login.vo.LoginAccountVO;
import com.lm.assessment.server.support.login.vo.TokenVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.beans.ConstructorProperties;
import java.util.Collections;
import java.util.Date;

/**
 * @author yond
 * @date 2023/10/20
 * @description 登录
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping("token")
    public RemoteResponse<TokenVO> token(@RequestBody LoginAccountVO login) {
        String account = login.getUsername();
        UserDO user = null;
        if (RegexConstant.MOBILE_PATTERN.matcher(account).matches()) {
            user = userService.getByMobile(account);
        }else {
            user = userService.getByEmail(account);
        }
        if (user == null) {
            return RemoteResponse.<TokenVO>custom().setFailure("账号不存在");
        }
        String password = user.getPassword();
        if (!password.equals(login.getPassword())) {
            return RemoteResponse.<TokenVO>custom().setFailure("密码错误");
        }
        TokenVO result = new TokenVO();
        PayloadHelper payloadHelper = new PayloadHelper()
                .setIssuer(JwtConstant.DEFAULT_CLIENT)
                .setIssuedAt(new Date())
                .setSubject(user.getGuid())
                .setSecret(JwtConstant.DEFAULT_SECRET)
                .setAdditionalInfo(Collections.emptyMap());
        String token = JwtUtil.creatToken(payloadHelper, JwtConstant.LOGIN_TIME);
        result.setToken(token);
        return RemoteResponse.success(result);
    }

    @GetMapping("code")
    public RemoteResponse<String> token() {
        return RemoteResponse.success("https://img1.baidu.com/it/u=1070984255,945844267&fm=253&fmt=auto&app=138&f=PNG?w=491&h=236");
    }

}
