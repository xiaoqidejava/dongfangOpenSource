package com.xiaoqi.test;

import com.xiaoqi.FactoryBean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Rookie Coder
 * @Description spring工厂Bean 以及Bean的生命周期 和 后置处理器 BeanPostProcessor
 * @Date
 **/
public class MyTest {

    /*
     * @Author liu-miss
     * @Description 测试FactoryBean
     * @Date 13:32 2021/7/15
     * @Param []
     * @return void
     **/
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Student student = context.getBean("bean", Student.class);
        Class<? extends Student> aClass = student.getClass();
        System.out.println(aClass);
    }

    /*
     * @Author liu-miss
     * @Description 测试默认情况下创建的Bean是单实例对象还是多实例对象
     * @Date 13:32 2021/7/15
     * @Param []
     * @return void
     **/

    @Test
    public void test2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        com.xiaoqi.Bean.Student student2 = context.getBean("student2", com.xiaoqi.Bean.Student.class);
        context.close();

    }

}
