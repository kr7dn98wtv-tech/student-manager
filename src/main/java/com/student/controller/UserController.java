package com.student.controller;

import com.student.common.Result;
import com.student.entity.User;
import com.student.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    Result insert(@RequestBody User user){
        userService.insert(user);
        return Result.success();
    }
    @PostMapping("/login")
    Result login(@RequestBody User user){
        String token = userService.login(user);
        if (token==null){
            return Result.error("用户名或密码错误");
        }
        return Result.success(token);
    }


}
