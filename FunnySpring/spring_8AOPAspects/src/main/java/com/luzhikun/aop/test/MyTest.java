package com.luzhikun.aop.test;

import com.luzhikun.aop.aopanno.UserDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class MyTest {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        // 前置通知
        // 基于注解方式实现的aop操作
        userDao.tell();
    }

}
