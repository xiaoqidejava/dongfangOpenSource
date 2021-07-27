package com.luzhikun.service;

import com.luzhikun.domain.GoodsUser;

import java.util.ArrayList;

public interface IUserService {
    /*
     * @Author liu-miss
     * @Description 添加用户
     * @Date 7:21 2021/5/26
     * @Param [goodsUser]
     * @return java.lang.Boolean
     **/
    Boolean UserAdd(GoodsUser goodsUser);

    /*
     * @Author liu-miss
     * @Description 查询所有用户
     * @Date 7:21 2021/5/26
     * @Param [cpage, count, keywords]
     * @return java.util.ArrayList<com.luzhikun.domain.GoodsUser>
     **/
    ArrayList<GoodsUser> selectAll(int cpage, int count, String keywords);

    /*
     * @Author liu-miss
     * @Description 查询页数和总记录数
     * @Date 7:21 2021/5/26
     * @Param [count, keywords] count:当前一页所能容纳的数据条数  keywords：当前关键字[不一定有]
     * @return int[]
     **/
    int[] totalPage(int count, String keywords);

    /*
     * @Author liu-miss
     * @Description 通过用户id查找用户
     * @Date 7:30 2021/5/26
     * @Param [useId]
     * @return com.luzhikun.domain.GoodsUser
     **/
    GoodsUser selectById(String useId);

    /*
     * @Author liu-miss
     * @Description 通过查找用户名 修改指定用户信息
     * @Date 18:00 2021/5/27
     * @Param [username, goodsUser]
     * @return boolean
     **/
    boolean userUpdateById(String username, GoodsUser goodsUser);

    /*
     * @Author liu-miss
     * @Description 通过id删除用户
     * @Date 18:00 2021/5/27
     * @Param [id]
     * @return boolean
     **/
    boolean deleteUser(String id);

    /*
     * @Author liu-miss
     * @Description 查找指定用户名的用户是否存在
     * @Date 18:00 2021/5/27
     * @Param [username]
     * @return boolean
     **/
    boolean selectUsername(String username);

    /*
     * @Author liu-miss
     * @Description //TODO 小柒的Java
     * @Date 20:11 2021/5/27
     * @Param
     * @return
     **/
    GoodsUser selectUsername(String username,String password);
}
