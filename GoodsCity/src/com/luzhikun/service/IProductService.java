package com.luzhikun.service;

import com.luzhikun.domain.Goods_Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/*
 * @Author liu-miss
 * @Description 商品业务层
 * @Date 20:43 2021/5/31
 **/
public interface IProductService {

    /*
     * @Author liu-miss
     * @Description 商品添加
     * @Date 20:44 2021/5/31
     * @Param [goods_product]
     * @return double
     **/
    boolean insertProduct(Goods_Product goods_product);

    /*
     * @Author liu-miss
     * @Description 查询所有的商品
     * @Date 21:41 2021/5/31
     * @Param []
     * @return java.util.List<com.luzhikun.domain.Goods_Product>
     **/
    List<Goods_Product> selectAll();

    /*
     * @Author liu-miss
     * @Description 通过商品id查询到指定商品
     * @Date 22:19 2021/5/31
     * @Param [productId]
     * @return com.luzhikun.domain.Goods_Product
     **/
    Goods_Product selectById(int productId);

    /*
     * @Author liu-miss
     * @Description 商品修改
     * @Date 22:58 2021/5/31
     * @Param [id, productName, price, productdesc, stock]
     * @return boolean
     **/
    boolean updateProduct(int id, String productName, int price, String productdesc, int stock);

    /*
     * @Author liu-miss
     * @Description 商品删除
     * @Date 23:24 2021/5/31
     * @Param [productId]
     * @return boolean
     **/
    boolean deleteById(int productId);

    /*
     * @Author liu-miss
     * @Description 通过父id查找到所有商品
     * @Date 18:03 2021/6/1
     * @Param [id]
     * @return java.util.ArrayList<com.luzhikun.domain.Goods_Product>
     **/
    ArrayList<Goods_Product> selectAllByFId(int id);

    /*
     * @Author liu-miss
     * @Description 通过子id查找到所有商品
     * @Date 18:03 2021/6/1
     * @Param [id]
     * @return java.util.ArrayList<com.luzhikun.domain.Goods_Product>
     **/
    ArrayList<Goods_Product> selectAllByCId(int id);

    /*
     * @Author liu-miss
     * @Description 通过多个id查询多个商品
     * @Date 22:21 2021/6/1
     * @Param [ibs]
     * @return java.util.ArrayList<com.luzhikun.domain.Goods_Product>
     **/
    ArrayList<Goods_Product> selectAllById(ArrayList<Integer> ibs);
}
