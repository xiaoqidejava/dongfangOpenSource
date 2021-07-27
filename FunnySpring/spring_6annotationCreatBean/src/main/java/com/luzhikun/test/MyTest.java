package com.luzhikun.test;

import com.luzhikun.config.SpringConfig;
import com.luzhikun.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Rookie Coder
 * @Description spring中基于注解方式创建对象 以及 开启组件扫描标签和他的一些配置信息
 * @Date
 **/
public class MyTest {

    @Test
    public void  test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = context.getBean("userService", UserService.class);
        // this is Service注解创建的bean对象
        // DaoImpl实现类
        userService.say();
    }

    @Test
    public void  test2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        // this is Service注解创建的bean对象
        // DaoImpl实现类
        userService.say();
    }

}
