package com.xiaoqi.service;

import com.xiaoqi.dao.UserMapper;
import com.xiaoqi.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> selectUser(){
        return userMapper.selectUser();
    }

}
