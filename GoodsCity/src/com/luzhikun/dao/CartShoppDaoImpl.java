package com.luzhikun.dao;

import com.luzhikun.db.JDBCUtil;
import com.luzhikun.domain.Goods_Cart;
import com.luzhikun.domain.Goods_Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class CartShoppDaoImpl implements ICartShoppDao{

    /*
     * @Author liu-miss
     * @Description 添加用户购物车商品信息
     * @Date 14:33 2021/6/2
     * @Param
     * @return
     **/

    @Override
    public boolean insertProductToCar(Goods_Cart goods_cart) {

        String sql = "insert into goods_cart values(null,?,?,?,?,?,?,?,1) ";

        Object[] objects = {
                goods_cart.getCart_p_filename(),
                goods_cart.getCart_p_name(),
                goods_cart.getCart_p_price(),
                goods_cart.getCart_quantity(),
                goods_cart.getCart_p_stock(),
                goods_cart.getCart_p_id(),
                goods_cart.getCart_u_id(),
                };

        return JDBCUtil.addDelUpdate(sql, objects);

    }

    /*
     * @Author liu-miss
     * @Description 通过用户名查找到该用户的所有购物车记录
     * @Date 15:26 2021/6/2
     * @Param [user_id]
     * @return java.util.ArrayList<com.luzhikun.domain.Goods_Cart>
     **/
    @Override
    public ArrayList<Goods_Cart> getCart(String user_id) {
        ArrayList<Goods_Cart> cartArrayList=null;
        Goods_Cart goods_cart=null;
        Connection connection=null;
        PreparedStatement pst=null;
        ResultSet rs=null;

        String sql="select * from goods_cart where  cart_u_id = ? and cart_valid = 1 order by cart_id desc ";
        try {
            connection= JDBCUtil.getConnection();
            pst=connection.prepareStatement(sql);
            pst.setString(1,user_id);
            rs = pst.executeQuery();
            if (rs!=null){
                cartArrayList=new ArrayList<>();
                while (rs.next()){
                    goods_cart=new Goods_Cart();

                    goods_cart.setCart_id(rs.getInt("cart_id"));
                    goods_cart.setCart_p_filename(rs.getString("cart_p_filename"));
                    goods_cart.setCart_p_name(rs.getString("cart_p_name"));
                    goods_cart.setCart_p_price(rs.getInt("cart_p_price"));
                    goods_cart.setCart_quantity(rs.getInt("cart_quantity"));
                    goods_cart.setCart_p_stock(rs.getInt("cart_p_stock"));
                    goods_cart.setCart_u_id(rs.getString("cart_u_id"));
                    goods_cart.setCart_p_id(rs.getInt("cart_p_id"));
                    goods_cart.setCart_valid(rs.getInt("cart_valid"));
                    cartArrayList.add(goods_cart);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeAll(rs,pst,connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return cartArrayList;
    }

    @Override
    public Goods_Cart selectById(String user_id, int pid) {
        Goods_Cart goods_cart=null;
        Connection connection=null;
        PreparedStatement pst=null;
        ResultSet rs=null;

        String sql="select * from goods_cart where  cart_u_id = ? and cart_p_id  = ?  ";
        try {
            connection= JDBCUtil.getConnection();
            pst=connection.prepareStatement(sql);
            pst.setString(1,user_id);
            pst.setInt(2,pid);
            rs = pst.executeQuery();
            if (rs!=null){

                while (rs.next()){
                    goods_cart=new Goods_Cart();
                    goods_cart.setCart_id(rs.getInt("cart_id"));
                    goods_cart.setCart_p_filename(rs.getString("cart_p_filename"));
                    goods_cart.setCart_p_name(rs.getString("cart_p_name"));
                    goods_cart.setCart_p_price(rs.getInt("cart_p_price"));
                    goods_cart.setCart_quantity(rs.getInt("cart_quantity"));
                    goods_cart.setCart_p_stock(rs.getInt("cart_p_stock"));
                    goods_cart.setCart_u_id(rs.getString("cart_u_id"));
                    goods_cart.setCart_p_id(rs.getInt("cart_p_id"));
                    goods_cart.setCart_valid(rs.getInt("cart_valid"));

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeAll(rs,pst,connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

     return  goods_cart;
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

        String sql="update goods_cart set cart_quantity= ?  where cart_p_id = ? ";
        Object[] parms={
                allCount,productId
        };
        return JDBCUtil.addDelUpdate(sql, parms);

    }

    /*
     * @Author liu-miss
     * @Description 通过商品id删除商品
     * @Date 20:53 2021/6/2
     * @Param [pesid]
     * @return boolean
     **/
    @Override
    public boolean deleteCart(int pesid) {

        String sql="delete from goods_cart where cart_id = ?";
        Object[] objects={
                pesid
        };
        return JDBCUtil.addDelUpdate(sql,objects);
        
    }

    /*
     * @Author liu-miss
     * @Description 通过购物车商品id查找到指定商品
     * @Date 21:35 2021/6/2
     * @Param [s]
     * @return com.luzhikun.domain.Goods_Cart
     **/
    @Override
    public Goods_Cart getOneCart(int cartId) {
        Goods_Cart goods_cart=null;
        Connection connection=null;
        PreparedStatement pst=null;
        ResultSet rs=null;

        String sql="select * from goods_cart where  cart_id = ? ";
        try {
            connection= JDBCUtil.getConnection();
            pst=connection.prepareStatement(sql);
            pst.setInt(1,cartId);

            rs = pst.executeQuery();
            if (rs!=null){
                while (rs.next()){
                    goods_cart=new Goods_Cart();
                    goods_cart.setCart_id(rs.getInt("cart_id"));
                    goods_cart.setCart_p_filename(rs.getString("cart_p_filename"));
                    goods_cart.setCart_p_name(rs.getString("cart_p_name"));
                    goods_cart.setCart_p_price(rs.getInt("cart_p_price"));
                    goods_cart.setCart_quantity(rs.getInt("cart_quantity"));
                    goods_cart.setCart_p_stock(rs.getInt("cart_p_stock"));
                    goods_cart.setCart_u_id(rs.getString("cart_u_id"));
                    goods_cart.setCart_p_id(rs.getInt("cart_p_id"));
                    goods_cart.setCart_valid(rs.getInt("cart_valid"));

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeAll(rs,pst,connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return  goods_cart;
    }

}
