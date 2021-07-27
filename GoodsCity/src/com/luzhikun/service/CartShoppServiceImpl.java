package com.luzhikun.service;

import com.luzhikun.dao.CartShoppDaoImpl;
import com.luzhikun.dao.ICartShoppDao;
import com.luzhikun.domain.Goods_Cart;

import java.util.ArrayList;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class CartShoppServiceImpl implements  ICartShoppService{

    ICartShoppDao icp=null;
    public CartShoppServiceImpl(){
        this.icp=new CartShoppDaoImpl();
    }
    /*
     * @Author liu-miss
     * @Description 添加用户购物车商品信息
     * @Date 14:33 2021/6/2
     * @Param
     * @return
     **/

    @Override
    public boolean insertProductToCar(Goods_Cart goods_cart) {
        return icp.insertProductToCar(goods_cart);
    }

    @Override
    public ArrayList<Goods_Cart> getCart(String user_id) {
        return icp.getCart(user_id);
    }

    /*
     * @Author liu-miss
     * @Description 通过用户id 和商品id 查找购物车有无此商品记录
     * @Date 19:37 2021/6/2
     * @Param [user_id, pid]
     * @return com.luzhikun.domain.Goods_Cart
     **/
    @Override
    public Goods_Cart selectById(String user_id, int pid) {


        return icp.selectById(user_id,pid);
    }

    /*
     * @Author liu-miss
     * @Description 修改购物车中商品的数量
     * @Date 19:54 2021/6/2
     * @Param [productId, allCount]
     * @return void
     **/
    @Override
    public boolean updateCount(int productId, int allCount) {

       return icp.updateCount(productId,allCount);
    }

    /*
     * @Author liu-miss
     * @Description 通过商品id删除商品
     * @Date 20:52 2021/6/2
     * @Param [pesid]
     * @return boolean
     **/
    @Override
    public boolean deleteCart(int pesid) {

        return  icp.deleteCart(pesid);
    }

    @Override
    public Goods_Cart getOneCart(int cartId) {

        return icp.getOneCart(cartId);

    }
}
