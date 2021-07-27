package com.luzhikun.service;

import com.luzhikun.domain.Goods_Category;
import com.luzhikun.domain.Goods_Product;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author liu-miss
 * @Description 商品分类
 * @Date 20:33 2021/5/29
 **/
public interface ICateUserService {

    /*
     * @Author liu-miss
     * @Description 查找到到所有的商品
     * @Date 20:48 2021/5/29
     * @Param []
     * @return com.luzhikun.domain.Goods_Category
     **/
    List<Goods_Category> getGoodsCate();

    /*
     * @Author liu-miss
     * @Description 添加商品
     * @Date 10:34 2021/5/30
     * @Param [parentId, className]
     * @return boolean
     **/
    boolean goodsAdd(Goods_Category goods_category);

    /*
     * @Author liu-miss
     * @Description 通过id查找到指定分类
     * @Date 11:04 2021/5/30
     * @Param [id]
     * @return com.luzhikun.domain.Goods_Category
     **/
    Goods_Category selectCateById(int id);

    /*
     * @Author liu-miss
     * @Description 修改商品分类操作
     * @Date 12:16 2021/5/30
     * @Param
     * @return
     **/
    boolean updateGood(Goods_Category goods_category);

    /*
     * @Author liu-miss
     * @Description 根据商品id删除指定商品类别
     * @Date 13:30 2021/5/30
     * @Param [cateId]
     * @return boolean
     **/
    boolean deleteGood(String cateId);


    /*
     * @Author liu-miss
     * @Description 查询所有的子分类和父分类
     * @Date 14:43 2021/5/30
     * @Param
     * @return
     **/
    ArrayList<Goods_Category> selectAllCate(String flag);


}
