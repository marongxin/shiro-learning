package com.marongxin.springbootshiro.service;

import com.marongxin.springbootshiro.entity.User;

public interface UserService {
    User findByName(String name);

    User findById(Integer id);
}
