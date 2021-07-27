package com.xiaoqi.createBean.domain;

/**
 * @Author Rookie Coder
 * @Description 员工类
 * @Date
 **/
public class Emp {

    private String name;
    private int age;
    private Dept dept;

    public Emp() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void add(){
        System.out.println("我是员工"+this.name+ this.age);
        System.out.println("我是部门"+dept.getName());
    }
}
