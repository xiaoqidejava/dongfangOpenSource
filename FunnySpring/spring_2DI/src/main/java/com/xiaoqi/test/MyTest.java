package com.xiaoqi.test;

import com.xiaoqi.collectionType.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.xiaoqi.collectionType.CollectionDI;

/**
 * @Author Rookie Coder
 * @Description spring注入属性的方式以及注入特殊类型属性
 * @Date
 **/
public class MyTest {

    @Test
    public void test1(){

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        CollectionDI collectionDI = context.getBean("collectionDI", CollectionDI.class);
        collectionDI.test();

    }

    @Test
    public void test2(){

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Book book = context.getBean("book", Book.class);
        book.say();

    }

}
