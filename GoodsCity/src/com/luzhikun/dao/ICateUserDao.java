package com.luzhikun.dao;

import com.luzhikun.domain.Goods_Category;

import java.util.ArrayList;
import java.util.List;

public interface ICateUserDao {

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
     * @Description 商品类别添加
     * @Date 10:39 2021/5/30
     * @Param [parentId, className]
     * @return boolean
     **/
    boolean goodsAdd(Goods_Category goods_category);

    /*
     * @Author liu-miss
     * @Description 通过商品id查找到指定商品类别
     * @Date 11:09 2021/5/30
     * @Param [id]
     * @return com.luzhikun.domain.Goods_Category
     **/
    Goods_Category selectCateById(int id);

    /*
     * @Author liu-miss
     * @Description 修改商品类别
     * @Date 12:18 2021/5/30
     * @Param [id, goods_category]
     * @return boolean
     **/
    boolean updateGood(Goods_Category goods_category);

    /*
     * @Author liu-miss
     * @Description 根据指定id删除指定商品
     * @Date 13:31 2021/5/30
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
