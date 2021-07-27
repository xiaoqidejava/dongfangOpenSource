package com.luzhikun.service;

import com.luzhikun.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
@Service
public class UserService {

    @Value(value = "xiaoqi")
    private String name;

     @Autowired // 根据属性类型进行注入
    // @Qualifier("userDaoImpl1") // 根据属性名称进行注入
    // 根据类型类型注入
//    @Resource
    // 根据属性名称注入
    // @Resource(name="userDaoImpl1")
    private UserDao userDao;


    public void say(){
        System.out.println("this is Service注解创建的bean对象");
        userDao.say();
    }
}
