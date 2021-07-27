package com.xiaoqi.test;

import com.xiaoqi.dao.UserMapper;
import com.xiaoqi.domain.User;
import com.xiaoqi.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class MyTest {

//    @Test
//    public void testMybatis() throws IOException {
//        String resource = "mybatisConfig.xml";
//        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
//
//        SqlSession sqlSession = build.openSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = mapper.selectUser();
//        System.out.println(users);
//
//    }

    @Test
    public void testSpring(){

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
//        String[] beanDefinitionNames = context.getBeanDefinitionNames();
//        for (String s:beanDefinitionNames) {
//            System.out.println(s);
//        }
        UserService userService = context.getBean("userService", UserService.class);
        List<User> users = userService.selectUser();
        System.out.println(users);

    }

    @Test
    public void testSpringmvc(){


    }

}
