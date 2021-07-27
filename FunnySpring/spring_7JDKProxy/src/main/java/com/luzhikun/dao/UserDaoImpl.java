package com.luzhikun.dao;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class UserDaoImpl implements UserDao{
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public String say(String name) {
        return name;
    }
}
