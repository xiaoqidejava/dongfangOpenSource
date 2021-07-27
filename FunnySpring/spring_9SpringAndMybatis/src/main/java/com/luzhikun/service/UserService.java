package com.luzhikun.service;

import com.luzhikun.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void insertUser(String username,String password){
        userDao.insertUser(username,password);
    }

}
