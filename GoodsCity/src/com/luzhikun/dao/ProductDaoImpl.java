package com.luzhikun.dao;

import com.luzhikun.db.JDBCUtil;
import com.luzhikun.domain.GoodsUser;
import com.luzhikun.domain.Goods_Category;
import com.luzhikun.domain.Goods_Product;
import com.luzhikun.service.IProductService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Rookie Coder
 * @Description 商品持久层操作
 * @Date
 **/
public class ProductDaoImpl implements IProductDao {


    /*
     * @Author liu-miss
     * @Description 商品添加
     * @Date 20:47 2021/5/31
     * @Param [goods_product]
     * @return double
     **/
    @Override
    public boolean insertProduct(Goods_Product goods_product) {
        String sql = "insert into goods_product values(null,?,?,?,?,?,?,?) ";

        Object[] objects = {
                goods_product.getPRODUCT_NAME(), goods_product.getPRODUCT_DESCRIPTION(),
                goods_product.getPRODUCT_PRICE(), goods_product.getPRODUCT_STOCK(), goods_product.getPRODUCT_FID(),
                goods_product.getPRODUCT_CID(), goods_product.getPRODUCT_FILENAME()};

        return JDBCUtil.addDelUpdate(sql, objects);
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
        // 获取连接
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Goods_Product> productArrayList = null;

        String sql = "select * from goods_product ";
        try {
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs != null) {
                productArrayList = new ArrayList<>();
                while (rs.next()) {
                    Goods_Product goods_product = new Goods_Product();
                    goods_product.setPRODUCT_ID(rs.getInt("PRODUCT_ID"));
                    goods_product.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));
                    goods_product.setPRODUCT_DESCRIPTION(rs.getString("PRODUCT_DESCRIPTION"));
                    goods_product.setPRODUCT_PRICE(rs.getInt("PRODUCT_PRICE"));
                    goods_product.setPRODUCT_STOCK(rs.getInt("PRODUCT_STOCK"));
                    goods_product.setPRODUCT_FID(rs.getInt("PRODUCT_FID"));
                    goods_product.setPRODUCT_CID(rs.getInt("PRODUCT_CID"));
                    goods_product.setPRODUCT_FILENAME(rs.getString("PRODUCT_FILENAME"));

                    productArrayList.add(goods_product);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                JDBCUtil.closeAll(rs, pst, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return productArrayList;
    }

    /*
     * @Author liu-miss
     * @Description 通过id查询到指定商品
     * @Date 22:20 2021/5/31
     * @Param [productId]
     * @return com.luzhikun.domain.Goods_Product
     **/
    @Override
    public Goods_Product selectById(int productId) {

        Goods_Product gp=null;
        Connection connection=null;
        PreparedStatement pst=null;
        ResultSet rs=null;

        String sql="select * from goods_product where  PRODUCT_ID = ?";
        try {
            connection= JDBCUtil.getConnection();
            pst=connection.prepareStatement(sql);
            pst.setInt(1,productId);
            rs = pst.executeQuery();
            if (rs!=null){
                while (rs.next()){
                    gp=new Goods_Product();
                    gp.setPRODUCT_ID(productId);
                    gp.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));
                    gp.setPRODUCT_DESCRIPTION(rs.getString("PRODUCT_DESCRIPTION"));
                    gp.setPRODUCT_PRICE(rs.getInt("PRODUCT_PRICE"));
                    gp.setPRODUCT_STOCK(rs.getInt("PRODUCT_STOCK"));
                    gp.setPRODUCT_FID(rs.getInt("PRODUCT_FID"));
                    gp.setPRODUCT_CID(rs.getInt("PRODUCT_CID"));
                    gp.setPRODUCT_FILENAME(rs.getString("PRODUCT_FILENAME"));
                }
            }
            return gp;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeAll(rs,pst,connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return gp;
    }

    /*
     * @Author liu-miss
     * @Description 商品修改
     * @Date 23:00 2021/5/31
     * @Param [id, productName, price, productdesc, stock]
     * @return boolean
     **/
    @Override
    public boolean updateProduct(int id, String productName, int price, String productdesc, int stock) {

        String sql="update goods_product set PRODUCT_NAME= ? ,PRODUCT_PRICE=? ,PRODUCT_DESCRIPTION = ?, PRODUCT_STOCK =? where PRODUCT_ID = ? ";
        Object[] parms={
                productName,price,productdesc,stock,id
        };
        return JDBCUtil.addDelUpdate(sql, parms);
    }

    /*
     * @Author liu-miss
     * @Description 通过id删除商品
     * @Date 23:25 2021/5/31
     * @Param [productId]
     * @return boolean
     **/
    @Override
    public boolean delectById(int productId) {

        String sql="delete from goods_product where PRODUCT_ID = ?";
        Object[] objects={
                productId
        };
        return JDBCUtil.addDelUpdate(sql,objects);

    }

    /*
     * @Author liu-miss
     * @Description 通过父id查找到所有商品
     * @Date 18:06 2021/6/1
     * @Param [id]
     * @return java.util.ArrayList<com.luzhikun.domain.Goods_Product>
     **/
    @Override
    public ArrayList<Goods_Product> selectAllByFId(int id) {
        // 获取连接
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Goods_Product> productArrayList = null;

        String sql = "select * from goods_product where PRODUCT_FID = ? ";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            rs = pst.executeQuery();
            if (rs != null) {
                productArrayList = new ArrayList<>();
                while (rs.next()) {
                    Goods_Product goods_product = new Goods_Product();
                    goods_product.setPRODUCT_ID(rs.getInt("PRODUCT_ID"));
                    goods_product.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));
                    goods_product.setPRODUCT_DESCRIPTION(rs.getString("PRODUCT_DESCRIPTION"));
                    goods_product.setPRODUCT_PRICE(rs.getInt("PRODUCT_PRICE"));
                    goods_product.setPRODUCT_STOCK(rs.getInt("PRODUCT_STOCK"));
                    goods_product.setPRODUCT_FID(rs.getInt("PRODUCT_FID"));
                    goods_product.setPRODUCT_CID(rs.getInt("PRODUCT_CID"));
                    goods_product.setPRODUCT_FILENAME(rs.getString("PRODUCT_FILENAME"));

                    productArrayList.add(goods_product);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                JDBCUtil.closeAll(rs, pst, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return productArrayList;

    }


    /*
     * @Author liu-miss
     * @Description 通过子id查找到所有商品
     * @Date 18:06 2021/6/1
     * @Param [id]
     * @return java.util.ArrayList<com.luzhikun.domain.Goods_Product>
     **/
    @Override
    public ArrayList<Goods_Product> selectAllByCId(int id) {
        // 获取连接
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Goods_Product> productArrayList = null;

        String sql = "select * from goods_product where PRODUCT_CID = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            rs = pst.executeQuery();
            if (rs != null) {
                productArrayList = new ArrayList<>();
                while (rs.next()) {
                    Goods_Product goods_product = new Goods_Product();
                    goods_product.setPRODUCT_ID(rs.getInt("PRODUCT_ID"));
                    goods_product.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));
                    goods_product.setPRODUCT_DESCRIPTION(rs.getString("PRODUCT_DESCRIPTION"));
                    goods_product.setPRODUCT_PRICE(rs.getInt("PRODUCT_PRICE"));
                    goods_product.setPRODUCT_STOCK(rs.getInt("PRODUCT_STOCK"));
                    goods_product.setPRODUCT_FID(rs.getInt("PRODUCT_FID"));
                    goods_product.setPRODUCT_CID(rs.getInt("PRODUCT_CID"));
                    goods_product.setPRODUCT_FILENAME(rs.getString("PRODUCT_FILENAME"));

                    productArrayList.add(goods_product);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                JDBCUtil.closeAll(rs, pst, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return productArrayList;

    }

    /*
     * @Author liu-miss
     * @Description 通过多个参数id查询多个商品
     * @Date 22:22 2021/6/1
     * @Param [ibs]
     * @return java.util.ArrayList<com.luzhikun.domain.Goods_Product>
     **/
    @Override
    public ArrayList<Goods_Product> selectAllById(ArrayList<Integer> ibs) {
        // 获取连接
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Goods_Product> productArrayList = null;


        try {
            for (int i = 0; i < ibs.size(); i++) {
            String sql = "select * from goods_product where PRODUCT_ID = ?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1,ibs.get(i));
            rs = pst.executeQuery();
            if (rs != null) {
                productArrayList = new ArrayList<>();
                while (rs.next()) {
                    Goods_Product goods_product = new Goods_Product();
                    goods_product.setPRODUCT_ID(rs.getInt("PRODUCT_ID"));
                    goods_product.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));
                    goods_product.setPRODUCT_DESCRIPTION(rs.getString("PRODUCT_DESCRIPTION"));
                    goods_product.setPRODUCT_PRICE(rs.getInt("PRODUCT_PRICE"));
                    goods_product.setPRODUCT_STOCK(rs.getInt("PRODUCT_STOCK"));
                    goods_product.setPRODUCT_FID(rs.getInt("PRODUCT_FID"));
                    goods_product.setPRODUCT_CID(rs.getInt("PRODUCT_CID"));
                    goods_product.setPRODUCT_FILENAME(rs.getString("PRODUCT_FILENAME"));
                    productArrayList.add(goods_product);
                }
            }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                JDBCUtil.closeAll(rs, pst, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return productArrayList;

    }
}


