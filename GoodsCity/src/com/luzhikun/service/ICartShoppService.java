package com.luzhikun.service;

import com.luzhikun.domain.Goods_Cart;

import java.util.ArrayList;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public interface ICartShoppService {

    /*
     * @Author liu-miss
     * @Description 添加用户购物车商品信息
     * @Date 14:33 2021/6/2
     * @Param
     * @return
     **/
    boolean insertProductToCar(Goods_Cart goods_cart);

    /*
     * @Author liu-miss
     * @Description 通过用户id查找到指定购物车的所有商品
     * @Date 15:24 2021/6/2
     * @Param [user_id]
     * @return java.util.ArrayList<com.luzhikun.domain.Goods_Cart>
     **/
    ArrayList<Goods_Cart> getCart(String user_id);

    /*
     * @Author liu-miss
     * @Description 查找购物车中有无此记录
     * @Date 19:36 2021/6/2
     * @Param [user_id, pid]
     * @return com.luzhikun.domain.Goods_Cart
     **/
    Goods_Cart selectById(String user_id, int pid);

    /*
     * @Author liu-miss
     * @Description 修改购物车中商品的数量
     * @Date 19:54 2021/6/2
     * @Param [productId, allCount]
     * @return void
     **/
    boolean updateCount(int productId, int allCount);

    /*
     * @Author liu-miss
     * @Description 通过商品id删除商品
     * @Date 20:52 2021/6/2
     * @Param [pesid]
     * @return boolean
     **/
    boolean deleteCart(int pesid);

    Goods_Cart getOneCart(int cartId);
}
