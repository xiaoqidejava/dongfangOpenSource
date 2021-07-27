package com.luzhikun.dao;

import com.luzhikun.db.JDBCUtil;
import com.luzhikun.domain.GoodsUser;

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
public class UserDaoImpl implements IUserDao {
    /*
     * @Author liu-miss
     * @Description 用户添加
     * @Date 10:37 2021/5/25
     * @Param [goodsUser]
     * @return boolean
     **/
    @Override
    public boolean userAdd(GoodsUser goodsUser) {

        String sql = "insert into goods_user() values(?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?,?)";
        Object[] objects = {
                goodsUser.getUSER_ID(),
                goodsUser.getUSER_NAME(),
                goodsUser.getUSER_PASSWORD(),
                goodsUser.getUSER_SEX(),
                goodsUser.getUSER_BIRTHDAY(),
                goodsUser.getUSER_IDENITY_CODE(),
                goodsUser.getUSER_EMAIL(),
                goodsUser.getUSER_MOBILE(),
                goodsUser.getUSER_ADDRESS(),
                goodsUser.getUSER_STATUS()};

        return JDBCUtil.addDelUpdate(sql, objects);
    }

    /*
     * @Author liu-miss
     * @Description 查询所有用户
     * @Date 12:15 2021/5/25
     * @Param [] count--一页有多少数据    cpage---取第几页
     * @return java.util.ArrayList<com.luzhikun.domain.GoodsUser>
     **/
    @Override
    public ArrayList<GoodsUser> selectALl(int cpage, int count, String keywords) {
        // 获取连接
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<GoodsUser> userArrayList = null;

        try {

            String sql = "";
            if (keywords != null) {
                sql = "select * from goods_user where USER_NAME like ? order by USER_BIRTHDAY desc limit ?,?";
                pst = connection.prepareStatement(sql);
                pst.setString(1, "%" + keywords + "%");
                pst.setInt(2, (cpage - 1) * count);
                pst.setInt(3, count);
            }
            if (keywords == null) {
                sql = "select * from goods_user  order by USER_BIRTHDAY desc limit ?,?";
                pst = connection.prepareStatement(sql);
                pst.setInt(1, (cpage - 1) * count);
                pst.setInt(2, count);
            }

            rs = pst.executeQuery();
            if (rs != null) {
                userArrayList = new ArrayList<>();
                while (rs.next()) {
                    GoodsUser goodsUser = new GoodsUser();
                    goodsUser.setUSER_ID(rs.getString("USER_ID"));
                    goodsUser.setUSER_NAME(rs.getString("USER_NAME"));
                    goodsUser.setUSER_PASSWORD(rs.getString("USER_PASSWORD"));
                    goodsUser.setUSER_SEX(rs.getString("USER_SEX"));
                    goodsUser.setUSER_BIRTHDAY(rs.getString("USER_BIRTHDAY"));
                    goodsUser.setUSER_IDENITY_CODE(rs.getString("USER_IDENITY_CODE"));
                    goodsUser.setUSER_EMAIL(rs.getString("USER_EMAIL"));
                    goodsUser.setUSER_MOBILE(rs.getString("USER_MOBILE"));
                    goodsUser.setUSER_ADDRESS(rs.getString("USER_ADDRESS"));
                    goodsUser.setUSER_STATUS(rs.getInt("USER_STATUS"));
                    userArrayList.add(goodsUser);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeAll(rs, pst, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return userArrayList;
    }

    /*
     * @Author liu-miss
     * @Description 查询页数和总记录数
     * @Date 7:21 2021/5/26
     * @Param [count, keywords] count:当前一页所能容纳的数据条数  keywords：当前关键字[不一定有]
     * @return int[]
     **/
    @Override
    public int[] totalPage(int count, String keywords) {
        // 默认总记录数为第一个元素  总页数为第二个元素
        int[] arr = {0, 1};

        // 获取连接
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "";
        try {
            if (keywords != null) {
                sql = "select count(*) from goods_user where USER_NAME like ?";
                pst = connection.prepareStatement(sql);
                pst.setString(1, "%" + keywords + "%");

            }
            if (keywords == null) {
                sql = "select count(*) from goods_user";
                pst = connection.prepareStatement(sql);

            }
            rs = pst.executeQuery();
            while (rs.next()) {
                // 记录总记录数
                arr[0] = rs.getInt(1);
                if (arr[0] % count == 0) {
                    arr[1] = arr[0] / count;
                } else {
                    arr[1] = arr[0] / count + 1;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeAll(rs, pst, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return arr;
    }

    /*
     * @Author liu-miss
     * @Description 通过id查找用户
     * @Date 7:26 2021/5/26
     * @Param [userId]
     * @return com.luzhikun.domain.GoodsUser
     **/
    @Override
    public GoodsUser selectById(String username) {
        // 获取连接
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        GoodsUser goodsUser =null;
        try {
            String sql = "select m.*,DATE_FORMAT(m.USER_BIRTHDAY,'%Y-%m-%d')birthday from goods_user m where USER_ID = ?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, username);
            rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    goodsUser = new GoodsUser();
                    goodsUser.setUSER_ID(rs.getString("USER_ID"));
                    goodsUser.setUSER_NAME(rs.getString("USER_NAME"));
                    goodsUser.setUSER_PASSWORD(rs.getString("USER_PASSWORD"));
                    goodsUser.setUSER_SEX(rs.getString("USER_SEX"));
                    goodsUser.setUSER_BIRTHDAY(rs.getString("birthday"));
                    goodsUser.setUSER_IDENITY_CODE(rs.getString("USER_IDENITY_CODE"));
                    goodsUser.setUSER_EMAIL(rs.getString("USER_EMAIL"));
                    goodsUser.setUSER_MOBILE(rs.getString("USER_MOBILE"));
                    goodsUser.setUSER_ADDRESS(rs.getString("USER_ADDRESS"));
                    goodsUser.setUSER_STATUS(rs.getInt("USER_STATUS"));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeAll(rs, pst, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return goodsUser;
    }

    /*
     * @Author liu-miss
     * @Description 修改用户信息
     * @Date 19:44 2021/5/26
     * @Param [username, goodsUser]
     * @return boolean
     **/
    @Override
    public boolean userUpdateById(String username, GoodsUser goodsUser) {
        // 获取连接
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement pst = null;

        try {
            String sql = "update goods_user set" +
                    " USER_NAME=?," +
                    "USER_PASSWORD=?," +
                    "USER_SEX=?," +
                    "USER_BIRTHDAY=DATE_FORMAT(?,'%Y-%m-%d')," +
                    "USER_IDENITY_CODE=?," +
                    "USER_EMAIL=?," +
                    "USER_MOBILE=?," +
                    "USER_ADDRESS=?," +
                    "USER_STATUS=?   " +
                    " where USER_ID=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, goodsUser.getUSER_NAME());
            pst.setString(2, goodsUser.getUSER_PASSWORD());
            pst.setString(3, goodsUser.getUSER_SEX());
            pst.setString(4, goodsUser.getUSER_BIRTHDAY());
            pst.setString(5, goodsUser.getUSER_IDENITY_CODE());
            pst.setString(6, goodsUser.getUSER_EMAIL());
            pst.setString(7, goodsUser.getUSER_MOBILE());
            pst.setString(8, goodsUser.getUSER_ADDRESS());
            pst.setInt(9, goodsUser.getUSER_STATUS());
            pst.setString(10, goodsUser.getUSER_ID());

            int i = pst.executeUpdate();
            return i>0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeAll(null, pst, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return false;
    }

    /*
     * @Author liu-miss
     * @Description 通过id删除用户
     * @Date 19:43 2021/5/26
     * @Param [id]
     * @return boolean
     **/
    @Override
    public boolean deleteUser(String id) {
        // 获取连接
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement pst = null;

        try {
            String sql ="DELETE FROM goods_user WHERE USER_ID=?;";
            pst = connection.prepareStatement(sql);
            pst.setString(1, id);
            int i = pst.executeUpdate();
            return i>0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeAll(null, pst, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return false;
    }

    /*
     * @Author liu-miss
     * @Description 通过账号密码查询指定用户
     * @Date 20:13 2021/5/27
     * @Param [username, password]
     * @return boolean
     **/
    @Override
    public GoodsUser selectUsername(String username, String password) {
        // 获取连接
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        GoodsUser goodsUser=null;
        try {
            String sql = "select * from goods_user where USER_ID =  ? and USER_PASSWORD = ?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                goodsUser = new GoodsUser();
                goodsUser.setUSER_ID(rs.getString("USER_ID"));
                goodsUser.setUSER_NAME(rs.getString("USER_NAME"));
                goodsUser.setUSER_PASSWORD(rs.getString("USER_PASSWORD"));
                goodsUser.setUSER_SEX(rs.getString("USER_SEX"));
                goodsUser.setUSER_BIRTHDAY(rs.getString("USER_BIRTHDAY"));
                goodsUser.setUSER_IDENITY_CODE(rs.getString("USER_IDENITY_CODE"));
                goodsUser.setUSER_EMAIL(rs.getString("USER_EMAIL"));
                goodsUser.setUSER_MOBILE(rs.getString("USER_MOBILE"));
                goodsUser.setUSER_ADDRESS(rs.getString("USER_ADDRESS"));
                goodsUser.setUSER_STATUS(rs.getInt("USER_STATUS"));
                return goodsUser;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeAll(rs, pst, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return goodsUser;
    }

}
