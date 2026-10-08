package com.student.service;

import com.student.entity.User;

public interface UserService {
    void insert(User user);
    String login(User user);
}
