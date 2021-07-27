package com.xiaoqi.createBean.service;

import com.xiaoqi.createBean.Config;
import com.xiaoqi.createBean.domain.Emp;
import com.xiaoqi.createBean.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Rookie Coder
 * @Description sprin基于xml创建对象 和 spring注入属性的三种方式：set注入，构造注入，p名称空间注入
 * @Date
 **/
public class CreateBeanMethod {

/*
 * 创建Bean对象的三种方式
 *
 *    1.@Bean
 *    2.@Conmponet
 *    3.xml配置bean标签
 *
 **/
   @Test
   public void test1(){

      AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(Config.class);
      User user = (User) context.getBean("user");
      user.toString();

   }

   @Test
   public void test2(){

      ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
      UserService userService = context.getBean("userService", UserService.class);
      userService.tall();

   }

   @Test
   public void test3(){

      ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
      Emp emp = context.getBean("emp", Emp.class);
      emp.add();
   }

}
