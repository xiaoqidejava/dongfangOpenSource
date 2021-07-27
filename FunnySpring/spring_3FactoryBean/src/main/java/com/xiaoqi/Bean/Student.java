package com.xiaoqi.Bean;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class Student {

    private String username;
    private int age;

    public Student() {
        System.out.println("第一步：调用bean的无参构造器");
    }

    public Student(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("第二步：调用了bean的set方法");
        this.username = username;
    }

    // 在bean类中创建初始化方法
    public void init(){
        System.out.println("第四步：执行初始化方法");
    }

    // 在bean类中创建销毁方法
    public void destoryMethod(){
        System.out.println("第七步：执行销毁方法");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
