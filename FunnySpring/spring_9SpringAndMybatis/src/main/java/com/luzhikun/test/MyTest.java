package com.luzhikun.test;

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
//        String[] beanDefinitionNames = context.getBeanDefinitionNames();
//        for (String s:beanDefinitionNames
//             ) {
//            System.out.println("容器中的对象有："+s);
//        }
        UserService userService = context.getBean("userService", UserService.class);
        userService.insertUser("xiaoqi","daniu");

    }

}
