package com.lm.assessment.server.support.login.jwt;

import com.lm.assessment.common.utils.json.util.JsonUtils;
import com.lm.assessment.server.support.login.domain.PayloadHelper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yond
 * @date 2023/10/21
 * @description jwt
 */
public class JwtUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);

    public static String creatToken(PayloadHelper payloadHelper, long validTime) {
        final Map<String, Object> header = new HashMap<>(4, 1);
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        long nowMillis = payloadHelper.getIssuedAt().getTime();
        Date expireDate;
        if (validTime > 0) {
            expireDate = new Date(nowMillis + validTime);
        } else {
            expireDate = new Date(nowMillis + 60 * 60 * 1000);
        }
        JwtBuilder builder = Jwts.builder().setHeader(header)
                .setIssuer(payloadHelper.getIssuer())
                .setIssuedAt(payloadHelper.getIssuedAt())
                .setSubject(payloadHelper.getSubject())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, payloadHelper.getSecret().getBytes(StandardCharsets.UTF_8));
        payloadHelper.getAdditionalInfo().forEach(builder::claim);
        String compactJws = builder.compact();
        LOGGER.info("用户 :{} 生成 token <======> {}", payloadHelper.getSubject(), compactJws);
        return compactJws;
    }

    public static void main(String[] args) {
        PayloadHelper ass = new PayloadHelper().setIssuer("1").setIssuedAt(new Date())
                .setSubject("2").setSecret("ass").setAdditionalInfo(Collections.emptyMap());
        String s = JwtUtil.creatToken(ass, 2000);
        System.out.println(s);
        Claims ass1 = JwtUtil.validateJwt(s, "ass");
        System.out.println(ass1);
        System.out.println(JsonUtils.toJson(ass1));
    }

    /**
     * 在请求 API 之前验证 Token
     *
     * @param compactJws 已生成 Token
     * @param secret     密钥
     * @return claims 中有我们之前定义的字段，可以被获取
     */
    public static Claims validateJwt(String compactJws, String secret) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    // Only accept byte array
                    .setSigningKey(secret.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(compactJws)
                    .getBody();

            LOGGER.info("该token的用户的解析结果：{}", JsonUtils.toJson(claims));

            return claims;
        } catch (Exception e) {
            LOGGER.error("解析Jwt失败，要解析的token：{}", JsonUtils.toJson(claims), e);
        }
        return claims;
    }

}
