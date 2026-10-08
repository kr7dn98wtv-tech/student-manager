package com.student.service.impl;

import com.student.entity.User;
import com.student.mapper.UserMapper;
import com.student.service.UserService;
import com.student.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtUtils jwtUtils;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Override
    public void insert(User user) {
        String rawPassword = user.getPassword();
        String hashedPassword = encoder.encode(rawPassword);
        user.setPassword(hashedPassword);
        userMapper.insert(user);
    }

    @Override
    public String login(User user) {
        User dbUser = userMapper.selectByUsername(user.getUsername());
        if(dbUser==null){
    return null;
}
    if (!encoder.matches(user.getPassword(), dbUser.getPassword())){
        return null;
    }
    HashMap<String, Object> claims = new HashMap<>();
    claims.put("id",dbUser.getId());
    claims.put("username",dbUser.getUsername());
    return jwtUtils.generateToken(claims);
    }


}
