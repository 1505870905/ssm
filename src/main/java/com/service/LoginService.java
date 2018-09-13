package com.service;

import com.dao.UserMapper;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserMapper userDao;
    public User findById(int id){
        User user = userDao.selectByPrimaryKey(id);
        return user;
    }
}
