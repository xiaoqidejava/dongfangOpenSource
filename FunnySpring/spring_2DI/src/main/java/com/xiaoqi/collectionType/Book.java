package com.xiaoqi.collectionType;

import java.util.List;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class Book {

    private List<Stu> stuList;

    public Book(List<Stu> stuList) {
        this.stuList = stuList;
    }

    public Book() {
    }

    public List<Stu> getStuList() {
        return stuList;
    }

    public void setStuList(List<Stu> stuList) {
        this.stuList = stuList;
    }

    public void say(){
        System.out.println(stuList);
    }
    @Override
    public String toString() {
        return "Book{" +
                "stuList=" + stuList +
                '}';
    }
}
