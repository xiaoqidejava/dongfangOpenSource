package com.luzhikun.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public interface UserDao {

     void addMoney(@Param("money") int money,@Param("username") String username);
     void reduceMoney(@Param("money") int money,@Param("username") String username);


}
