package com.luzhikun.dao;

import com.luzhikun.domain.Goods_Product;

import java.util.ArrayList;
import java.util.List;

public interface IProductDao {

    /*
     * @Author liu-miss
     * @Description 商品添加
     * @Date 20:48 2021/5/31
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
     * @Description 通过id查询到指定商品
     * @Date 22:20 2021/5/31
     * @Param [productId]
     * @return com.luzhikun.domain.Goods_Product
     **/
    Goods_Product selectById(int productId);

    /*
     * @Author liu-miss
     * @Description 商品修改
     * @Date 23:00 2021/5/31
     * @Param [id, productName, price, productdesc, stock]
     * @return boolean
     **/
    boolean updateProduct(int id, String productName, int price, String productdesc, int stock);

    /*
     * @Author liu-miss
     * @Description 通过id删除商品
     * @Date 23:25 2021/5/31
     * @Param [productId]
     * @return boolean
     **/
    boolean delectById(int productId);

    /*
     * @Author liu-miss
     * @Description 通过父id查找到所有的商品
     * @Date 18:04 2021/6/1
     * @Param [id]
     * @return java.util.ArrayList<com.luzhikun.domain.Goods_Product>
     **/
    ArrayList<Goods_Product> selectAllByFId(int id);

    /*
     * @Author liu-miss
     * @Description 通过父id查找到所有的商品
     * @Date 18:04 2021/6/1
     * @Param [id]
     * @return java.util.ArrayList<com.luzhikun.domain.Goods_Product>
     **/
    ArrayList<Goods_Product> selectAllByCId(int id);

    ArrayList<Goods_Product> selectAllById(ArrayList<Integer> ibs);
}
