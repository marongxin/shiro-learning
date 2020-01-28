package com.marongxin.springbootshiro.service.impl;

import com.marongxin.springbootshiro.dao.UserDao;
import com.marongxin.springbootshiro.entity.User;
import com.marongxin.springbootshiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

}
