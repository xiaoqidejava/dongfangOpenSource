package com.xiaoqi.createBean.service;

import com.xiaoqi.createBean.dao.UserDao;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void tall(){
        System.out.println("service层");
        userDao.add();
    }
}
