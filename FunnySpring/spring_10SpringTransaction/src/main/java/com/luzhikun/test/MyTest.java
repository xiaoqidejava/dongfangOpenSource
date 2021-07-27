package com.luzhikun.test;

import com.luzhikun.domain.User;
import com.luzhikun.service.UserService;
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
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney(200);

    }

}
