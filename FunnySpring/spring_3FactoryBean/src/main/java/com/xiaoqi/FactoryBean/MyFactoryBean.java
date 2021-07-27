package com.xiaoqi.FactoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class MyFactoryBean implements FactoryBean<Student> {

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
    @Override
    public Student getObject() throws Exception {
        Student student= new Student();
        student.setAge(1);
        student.setName("xiaoqi0");
        return student;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
