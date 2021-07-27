package com.luzhikun.service;

import com.luzhikun.dao.IUserDao;
import com.luzhikun.dao.UserDaoImpl;
import com.luzhikun.domain.GoodsUser;

import java.util.ArrayList;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class UserServiceImpl implements IUserService {


    private IUserDao iUserDao = null;

    public UserServiceImpl() {
        iUserDao = new UserDaoImpl();
    }

    /*
     * @Author liu-miss
     * @Description 添加用户
     * @Date 7:21 2021/5/26
     * @Param [goodsUser]
     * @return java.lang.Boolean
     **/
    @Override
    public Boolean UserAdd(GoodsUser goodsUser) {
        return iUserDao.userAdd(goodsUser);
    }

    /*
     * @Author liu-miss
     * @Description 查询所有用户
     * @Date 7:21 2021/5/26
     * @Param [cpage, count, keywords]
     * @return java.util.ArrayList<com.luzhikun.domain.GoodsUser>
     **/
    @Override
    public ArrayList<GoodsUser> selectAll(int cpage, int count, String keywords) {
        return iUserDao.selectALl(cpage, count, keywords);
    }

    /*
     * @Author liu-miss
     * @Description 查询页数和总记录数
     * @Date 7:21 2021/5/26
     * @Param [count, keywords] count:当前一页所能容纳的数据条数  keywords：当前关键字[不一定有]
     * @return int[]
     **/
    @Override
    public int[] totalPage(int count, String keywords) {
        return iUserDao.totalPage(count, keywords);
    }

    /*
     * @Author liu-miss
     * @Description 通过username属性查找用户信息
     * @Date 18:03 2021/5/27
     * @Param [useId]
     * @return com.luzhikun.domain.GoodsUser
     **/
    @Override
    public GoodsUser selectById(String username) {
        return iUserDao.selectById(username);
    }

    /*
     * @Author liu-miss
     * @Description 更新用户信息 通过 username
     * @Date 19:42 2021/5/26
     * @Param [username, goodsUser]
     * @return boolean
     **/
    @Override
    public boolean userUpdateById(String username, GoodsUser goodsUser) {
        return iUserDao.userUpdateById(username,goodsUser);
    }

    /*
     * @Author liu-miss
     * @Description 通过id删除用户
     * @Date 19:42 2021/5/26
     * @Param [id]
     * @return boolean
     **/
    @Override
    public boolean deleteUser(String id) {
        return iUserDao.deleteUser(id);
    }

    /*
     * @Author liu-miss
     * @Description 查找指定用户名的用户是否存在
     * @Date 18:00 2021/5/27
     * @Param [username]
     * @return boolean
     **/
    @Override
    public boolean selectUsername(String username) {

        GoodsUser goodsUser = iUserDao.selectById(username);
//        System.out.println(goodsUser);
        if (goodsUser!=null){
//            System.out.println("有");
            return true;
        }
        else{
//            System.out.println("空");
            return false;
        }

    }

    /*
     * @Author liu-miss
     * @Description 查询是否有该用户名和密码的用户
     * @Date 20:12 2021/5/27
     * @Param [username, password]
     * @return boolean
     **/
    @Override
    public GoodsUser selectUsername(String username, String password) {
        return iUserDao.selectUsername(username,password);
    }
}
