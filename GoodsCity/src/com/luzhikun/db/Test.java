package com.luzhikun.db;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.luzhikun.domain.GoodsUser;
import com.luzhikun.service.UserServiceImpl;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class Test {
    public static void main(String[] args) throws SQLException {

//        Connection connection = JDBCUtil.getConnection();
//        System.out.println(connection);
//        if (connection!=null)
//        connection.close();
//        UserServiceImpl userService=new UserServiceImpl();
//        ArrayList<GoodsUser> userArrayList = userService.selectAll(1,5,"李");
//        Iterator<GoodsUser> iterator = userArrayList.iterator();
//        while (iterator.hasNext()){
//            GoodsUser next = iterator.next();
//            System.out.println(next);
//
//        }
//        int a=8;
//        for (int i = 0; i < 2; i++) {
//        if (a>6){
//            System.out.println(1);
//
//        }
//        else if (a>3){
//            System.out.println(2);
//        }
//       else if (a>1){
//            System.out.println(3);
//        }
//
//
//        }

//        Integer a=3;
//        int b=3;
//        System.out.println(a==b);
          File file=new File("web/images/product");
          System.out.println(file.exists());


    }
}
