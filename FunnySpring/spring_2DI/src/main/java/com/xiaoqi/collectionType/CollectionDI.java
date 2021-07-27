package com.xiaoqi.collectionType;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class CollectionDI {

    private int[] a;
    private List<String> list;
    private Map<String,String> map;
    private Set set;

    // 多个学生所学的课程
    private List<Stu> stus;
    public void setStus(List<Stu> stus) {
        this.stus = stus;
    }

    public CollectionDI() {
    }

    public CollectionDI(int[] a, List<String> list, Map<String, String> map, Set set) {
        this.a = a;
        this.list = list;
        this.map = map;
        this.set = set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setA(int[] a) {
        this.a = a;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

   public  void test(){
       System.out.println(a);
       System.out.println(list);
       System.out.println(map);
       System.out.println(stus);
   }
}
