package com.student.interceptor;

import com.student.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtUtils jwtUtils;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler){
        String token = request.getHeader("Authorization");
        // 标准格式是 "Bearer eyJ..."，先把 "Bearer " 前缀去掉
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);   // "Bearer " 正好 7 个字符
        }
        if (token==null||token.isEmpty()){
            response.setStatus(401);
            return false;
        }
        try {
            Claims claims = jwtUtils.parseToken(token);
            request.setAttribute("username",claims.get("username"));
        }catch (Exception e){
            //e.printStackTrace();
            response.setStatus(401);
            return false;
        }
        return true;
    }
}
