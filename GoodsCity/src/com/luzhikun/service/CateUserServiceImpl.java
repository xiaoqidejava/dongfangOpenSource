package com.luzhikun.service;

import com.luzhikun.dao.CateUserDaoImpl;
import com.luzhikun.dao.ICateUserDao;
import com.luzhikun.domain.Goods_Category;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class CateUserServiceImpl implements ICateUserService{

    // 创建商品dao层对象
    private ICateUserDao ic =null;

    /*
     * @Author liu-miss
     * @Description 查询所有商品类别
     * @Date 10:39 2021/5/30
     * @Param []
     * @return
     **/
   public CateUserServiceImpl(){
        ic=new CateUserDaoImpl();
    }
    @Override
    public List<Goods_Category> getGoodsCate() {
        return ic.getGoodsCate();
    }

    /*
     * @Author liu-miss
     * @Description 商品类别添加
     * @Date 10:39 2021/5/30
     * @Param [parentId, className]
     * @return boolean
     **/
    @Override
    public boolean goodsAdd(Goods_Category goods_category) {
        return ic.goodsAdd(goods_category);
    }

    /*
     * @Author liu-miss
     * @Description 通过id查找到指定商品类别
     * @Date 11:07 2021/5/30
     * @Param [id]
     * @return com.luzhikun.domain.Goods_Category
     **/
    @Override
    public Goods_Category selectCateById(int id) {
        return ic.selectCateById(id);
    }

    /*
     * @Author liu-miss
     * @Description 修改商品类别
     * @Date 12:18 2021/5/30
     * @Param [id, goods_category]
     * @return boolean
     **/
    @Override
    public boolean updateGood( Goods_Category goods_category) {
        return ic.updateGood(goods_category);
    }

    /*
     * @Author liu-miss
     * @Description 根据商品id删除指定商品类别
     * @Date 13:31 2021/5/30
     * @Param [cateId]
     * @return boolean
     **/
    @Override
    public boolean deleteGood(String cateId) {
        return ic.deleteGood(cateId);
    }

    /*
     * @Author liu-miss
     * @Description 查询所有的子分类和父分类
     * @Date 14:43 2021/5/30
     * @Param
     * @return
     **/
    @Override
    public ArrayList<Goods_Category> selectAllCate(String flag) {
        return ic.selectAllCate(flag);
    }
}
