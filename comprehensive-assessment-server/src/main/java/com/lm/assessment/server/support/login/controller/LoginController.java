package com.lm.assessment.server.support.login.controller;

import com.lm.assessment.common.constant.RegexConstant;
import com.lm.assessment.common.response.RemoteResponse;
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
@RestController("/login")
public class LoginController {

    @Resource
    private UserService userService;


    @RequestMapping("token")
    public ResponseEntity<TokenVO> token(LoginAccountVO login) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Cache-Control", "no-store");
        headers.set("Pragma", "no-cache");
        headers.set("Content-Type", "application/json;charset=UTF-8");
        String account = login.getAccount();
        if (RegexConstant.MOBILE_PATTERN.matcher(account).matches()) {
            userService.getByMobile("1");
        }
        // todo 查询用户与校验密码
        TokenVO token = new TokenVO();
        PayloadHelper payloadHelper = new PayloadHelper()
                .setIssuer(JwtConstant.DEFAULT_CLIENT)
                .setIssuedAt(new Date())
                .setSubject("1")
                .setSecret(JwtConstant.DEFAULT_SECRET)
                .setAdditionalInfo(Collections.emptyMap());
        JwtUtil.creatToken(payloadHelper, JwtConstant.LOGIN_TIME);
        return new ResponseEntity<>(token, headers, HttpStatus.OK);
    }

    @GetMapping("code")
    public RemoteResponse<String> token() {
        return RemoteResponse.success("https://img1.baidu.com/it/u=1070984255,945844267&fm=253&fmt=auto&app=138&f=PNG?w=491&h=236");
    }

}
