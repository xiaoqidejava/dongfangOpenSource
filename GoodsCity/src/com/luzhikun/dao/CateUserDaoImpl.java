package com.luzhikun.dao;

import com.luzhikun.db.JDBCUtil;
import com.luzhikun.domain.Goods_Category;
import com.luzhikun.service.ICateUserService;
import jdk.nashorn.internal.scripts.JD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class CateUserDaoImpl implements ICateUserDao {

    /*
     * @Author liu-miss
     * @Description 查找到到所有的商品
     * @Date 20:48 2021/5/29
     * @Param []
     * @return com.luzhikun.domain.Goods_Category
     **/
    @Override
    public List<Goods_Category> getGoodsCate() {
        Goods_Category gc=null;
        Connection connection=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        List<Goods_Category> goodslist=null;

        String sql="select * from goods_category ";
        try {
            connection= JDBCUtil.getConnection();
            pst=connection.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs!=null){
                goodslist=new ArrayList<>();
                while (rs.next()){
                    gc=new Goods_Category();
                    int cate_id = rs.getInt("CATE_ID");
                    String cate_name = rs.getString("CATE_NAME");
                    int cate_parent_id = rs.getInt("CATE_PARENT_ID");
                    gc.setCATE_ID(cate_id);
                    gc.setCATE_NAME(cate_name);
                    gc.setCATE_PARENT_ID(cate_parent_id);
                    System.out.println("------------------------------");
                    System.out.println(cate_id);
                    System.out.println(cate_name);
                    System.out.println(cate_parent_id);
                    System.out.println("------------------------------");
                    goodslist.add(gc);
                }
            }
            return goodslist;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeAll(rs,pst,connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return goodslist;
    }

    /*
     * @Author liu-miss
     * @Description 商品类别添加
     * @Date 10:38 2021/5/30
     * @Param [parentId, className]
     * @return boolean
     **/
    @Override
    public boolean goodsAdd(Goods_Category goods_category) {

        String sql = "insert into goods_category() values(null,?,?) ";
        Object[] objects = {
                goods_category.getCATE_NAME(),goods_category.getCATE_PARENT_ID() };

        return JDBCUtil.addDelUpdate(sql, objects);

    }

    /*
     * @Author liu-miss
     * @Description 通过id查找到指定商品类别
     * @Date 11:12 2021/5/30
     * @Param [id]
     * @return com.luzhikun.domain.Goods_Category
     **/
    @Override
    public Goods_Category selectCateById(int id) {
        Goods_Category gc=null;
        Connection connection=null;
        PreparedStatement pst=null;
        ResultSet rs=null;

        String sql="select * from goods_category where  CATE_ID = ?";
        try {
            connection= JDBCUtil.getConnection();
            pst=connection.prepareStatement(sql);
            pst.setInt(1,id);
            rs = pst.executeQuery();
            if (rs!=null){
                while (rs.next()){
                    gc=new Goods_Category();
                    gc.setCATE_ID(id);
                    gc.setCATE_NAME(rs.getString("CATE_NAME"));
                    gc.setCATE_PARENT_ID(rs.getInt("CATE_PARENT_ID"));
                }
            }
            return gc;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeAll(rs,pst,connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return gc;
    }

    /*
     * @Author liu-miss
     * @Description 修改商品类别
     * @Date 12:18 2021/5/30
     * @Param [id, goods_category]
     * @return boolean
     **/
    @Override
    public boolean updateGood(Goods_Category goods_category) {
        String sql="update goods_category set CATE_NAME= ? ,CATE_PARENT_ID =? where CATE_ID = ? ";
        Object[] parms={
            goods_category.getCATE_NAME(),goods_category.getCATE_PARENT_ID(),goods_category.getCATE_ID()
        };
        return JDBCUtil.addDelUpdate(sql, parms);
    }

    /*
     * @Author liu-miss
     * @Description 根据指定id删除指定商品类别
     * @Date 13:33 2021/5/30
     * @Param [cateId]
     * @return boolean
     **/
    @Override
    public boolean deleteGood(String cateId) {

        String sql="delete from goods_category where CATE_ID = ?";
        Object[] objects={
                cateId
        };
        return JDBCUtil.addDelUpdate(sql,objects);
    }

    /*
     * @Author liu-miss
     * @Description 查询所有的子分类和父分类
     * @Date 14:45 2021/5/30
     * @Param [flag] flag == "father"  flag="child"
     * @return java.util.ArrayList<com.luzhikun.domain.Goods_Category>
     **/
    @Override
    public ArrayList<Goods_Category> selectAllCate(String flag) {
        Goods_Category gc=null;
        ArrayList<Goods_Category> goods_categories=null;
        Connection connection=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql=null;
        if (flag!=null && "father".equals(flag)){
            // 获取所有的父分类
            sql="select * from goods_category where CATE_PARENT_ID = 0";

        }else {
            // 获取所有的子分类
            sql="select * from goods_category where  CATE_PARENT_ID != 0 ";
        }
        try {
            connection= JDBCUtil.getConnection();
            pst=connection.prepareStatement(sql);

            rs = pst.executeQuery();
            if (rs!=null){
                goods_categories=new ArrayList<>();
                while (rs.next()){
                    gc=new Goods_Category();
                    gc.setCATE_ID(rs.getInt("CATE_ID"));
                    gc.setCATE_NAME(rs.getString("CATE_NAME"));
                    gc.setCATE_PARENT_ID(rs.getInt("CATE_PARENT_ID"));
                    goods_categories.add(gc);
                }
            }
            return goods_categories;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeAll(rs,pst,connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return goods_categories;
    }
}
