package com.lucy.test;

import com.lucy.autowire.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Rookie Coder
 * @Description spring基于xml的自动装配功能
 * @Date
 **/
public class MyTest {

    @Test
    public void test1(){

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);

    }

}
