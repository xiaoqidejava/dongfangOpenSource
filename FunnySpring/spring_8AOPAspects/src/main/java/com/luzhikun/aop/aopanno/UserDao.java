package com.luzhikun.aop.aopanno;

import org.springframework.stereotype.Component;

/**
 * @Author Rookie Coder
 * @Description 被增强的类
 * @Date
 **/
@Component
public class UserDao {
    public void tell(){
        System.out.println("基于注解方式实现的aop操作");
    }

}
