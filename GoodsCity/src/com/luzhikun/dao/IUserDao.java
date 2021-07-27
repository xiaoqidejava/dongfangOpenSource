package com.luzhikun.dao;

import com.luzhikun.domain.GoodsUser;

import java.util.ArrayList;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public interface IUserDao {

    /*
     * @Author liu-miss
     * @Description 用户添加
     * @Date 10:36 2021/5/25
     * @Param [goodsUser]
     * @return boolean
     **/
    boolean userAdd(GoodsUser goodsUser);

    /*
     * @Author liu-miss
     * @Description 查询所有的用户
     * @Date 21:07 2021/5/25
     * @Param []
     * @return java.util.ArrayList<com.luzhikun.domain.GoodsUser>
     **/
    ArrayList<GoodsUser> selectALl(int cpage,int count,String keywords);

    /*
     * @Author liu-miss
     * @Description 查询页数和总记录数
     * @Date 7:21 2021/5/26
     * @Param [count, keywords] count:当前一页所能容纳的数据条数  keywords：当前关键字[不一定有]
     * @return int[]
     **/
    int[] totalPage(int count,String keywords);

    /*
     * @Author liu-miss
     * @Description 通过账号查询用户
     * @Date 8:36 2021/5/26
     * @Param [userId]
     * @return com.luzhikun.domain.GoodsUser
     **/
    GoodsUser selectById(String username);

    /*
     * @Author liu-miss
     * @Description 通过账号锁定用户 并修改用户信息
     * @Date 8:37 2021/5/26
     * @Param [username, goodsUser]
     * @return boolean
     **/
   boolean userUpdateById(String username, GoodsUser goodsUser);

   /*
    * @Author liu-miss
    * @Description 通过账号删除用户
    * @Date 20:17 2021/5/26
    * @Param [id]
    * @return boolean
    **/
    boolean deleteUser(String id);


    /*
     * @Author liu-miss
     * @Description 通过账号密码查询指定用户
     * @Date 20:13 2021/5/27
     * @Param [username, password]
     * @return boolean
     **/
    GoodsUser selectUsername(String username, String password);
}
