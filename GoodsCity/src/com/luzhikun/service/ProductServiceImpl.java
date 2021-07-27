package com.luzhikun.service;

import com.luzhikun.dao.IProductDao;
import com.luzhikun.dao.ProductDaoImpl;
import com.luzhikun.domain.Goods_Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class ProductServiceImpl implements IProductService{

    private IProductDao ipd=null;

    public ProductServiceImpl(){
        this.ipd=new ProductDaoImpl();
    }

    /*
     * @Author liu-miss
     * @Description 商品添加
     * @Date 20:45 2021/5/31
     * @Param [goods_product]
     * @return double
     **/
    @Override
    public boolean insertProduct(Goods_Product goods_product) {
        return ipd.insertProduct(goods_product);
    }

    /*
     * @Author liu-miss
     * @Description 查询所有的商品
     * @Date 21:41 2021/5/31
     * @Param []
     * @return java.util.List<com.luzhikun.domain.Goods_Product>
     **/
    @Override
    public List<Goods_Product> selectAll() {
        return ipd.selectAll();
    }

    @Override
    public Goods_Product selectById(int productId) {

        return ipd.selectById(productId);
    }

    /*
     * @Author liu-miss
     * @Description 商品修改
     * @Date 22:59 2021/5/31
     * @Param [id, productName, price, productdesc, stock]
     * @return boolean
     **/
    @Override
    public boolean updateProduct(int id, String productName, int price, String productdesc, int stock) {
        return  ipd.updateProduct(id,productName,price,productdesc,stock);
    }

    /*
     * @Author liu-miss
     * @Description 通过id删除指定商品
     * @Date 18:05 2021/6/1
     * @Param [productId]
     * @return boolean
     **/
    @Override
    public boolean deleteById(int productId) {
        return  ipd.delectById(productId);
    }

    /*
     * @Author liu-miss
     * @Description 通过父id查找到所有商品
     * @Date 18:05 2021/6/1
     * @Param [id]
     * @return java.util.ArrayList<com.luzhikun.domain.Goods_Product>
     **/
    @Override
    public ArrayList<Goods_Product> selectAllByFId(int id) {

        return ipd.selectAllByFId(id);
    }

    /*
     * @Author liu-miss
     * @Description 通过子id查找到所有商品
     * @Date 18:05 2021/6/1
     * @Param [id]
     * @return java.util.ArrayList<com.luzhikun.domain.Goods_Product>
     **/
    @Override
    public ArrayList<Goods_Product> selectAllByCId(int id) {

        return ipd.selectAllByCId(id);
    }

    @Override
    public ArrayList<Goods_Product> selectAllById(ArrayList<Integer> ibs) {

        return ipd.selectAllById(ibs);
    }
}
