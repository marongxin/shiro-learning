package com.marongxin.springbootshiro.dao;

import com.marongxin.springbootshiro.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
     User findByName(String name);

     User findById(Integer id);
}


