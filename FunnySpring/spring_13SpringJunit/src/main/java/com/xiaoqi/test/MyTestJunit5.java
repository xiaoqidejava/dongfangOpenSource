package com.xiaoqi.test;

import com.xiaoqi.dao.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/


public class MyTestJunit5 {
    @Autowired // 根据类型注入
    public UserService userService;
    @Test
    public void test1(){
        userService.toString();
    }
}
