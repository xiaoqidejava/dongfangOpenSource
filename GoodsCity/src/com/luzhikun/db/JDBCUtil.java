package com.luzhikun.db;


import com.luzhikun.domain.GoodsUser;
import org.omg.DynamicAny._DynEnumStub;
import sun.util.resources.cldr.br.CurrencyNames_br;
import sun.util.resources.cldr.ps.CurrencyNames_ps;

import java.sql.*;
import java.util.ArrayList;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class JDBCUtil {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /*
     * @Author liu-miss
     * @Description 获取数据库连接
     * @Date 10:18 2021/5/25
     * @Param []
     * @return java.sql.Connection
     **/
    public static Connection getConnection()  {
        Connection connection=null;
        String url="jdbc:mysql://localhost:3306/goodscity";
        String root="root";
        String password="140489lu";

        if (connection==null){
            try {
                connection= DriverManager.getConnection(url,root,password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }

    /*
     * @Author liu-miss
     * @Description 关闭操作
     * @Date 10:17 2021/5/25
     * @Param [rs, pst, connection]
     * @return void
     **/
    public static void closeAll(ResultSet rs, PreparedStatement pst,Connection connection) throws SQLException {
        if (rs!=null){
            rs.close();
        }
        if (pst!=null){
            pst.close();
        }
        if (connection!=null){
            connection.close();
        }
    }

    /*
     * @Author liu-miss
     * @Description 增删改
     * @Date 10:19 2021/5/25
     * @Param []
     * @return int
     **/
    public static boolean addDelUpdate(String sql,Object[] parms)  {
        // 获取连接
        Connection connection=null;
        PreparedStatement pst=null;
        try {
            connection=getConnection();
            pst = connection.prepareStatement(sql);
            for (int i = 0; i < parms.length; i++) {
                pst.setObject(i+1,parms[i]);
            }
            int i = pst.executeUpdate();
            return i>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                closeAll(null,pst,connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }


}
