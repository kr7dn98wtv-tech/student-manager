package com.student.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String secret;

    // 生成 token（发证 + 盖章）
    public String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)   // ① 装信息
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))  // ② 24小时后过期
                .signWith(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)))  // ③ 打成钥匙 → 盖章
                .compact();          // ④ 拼字符串
    }

    // 解析 token（验章 + 取信息）
    public Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)))  // ① 同一把钥匙验章
                .build()                        // ② 组装 parser
                .parseClaimsJws(token)          // ③ 解析+验证
                .getBody();                     // ④ 取信息
    }
}