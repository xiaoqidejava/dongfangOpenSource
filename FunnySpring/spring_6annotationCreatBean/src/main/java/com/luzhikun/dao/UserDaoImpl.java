package com.luzhikun.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
@Repository("userDaoImpl1")
public class UserDaoImpl implements UserDao{
    @Override
    public void say() {
        System.out.println("DaoImpl实现类");
    }
}
