package com.xiaoqi.test;

import com.xiaoqi.dao.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/

@RunWith(SpringJUnit4ClassRunner.class) // 指定单元测试框架版本
@ContextConfiguration("classpath:application.xml")// 加载配置文件
public class MyTest {
    @Autowired // 根据类型注入
    public UserService userService;
    @Test
    public void test1(){
        userService.toString();
    }
}
