package com.luzhikun.servlet.user;

import com.luzhikun.domain.GoodsUser;
import com.luzhikun.service.IUserService;
import com.luzhikun.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * @Author liu-miss
 * @Description 管理员添加用户
 * @Date 7:16 2021/5/25
 **/
@WebServlet(name = "DoUserAddServlet",value = "/manager/admin_douseradd")
public class DoUserAddServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        String stutas = request.getParameter("stutas");
        // 默认为普通用户
        int stuta=1;
        if (stutas!=null){
           stuta=Integer.parseInt(stutas);
        }
        GoodsUser goodsUser=new GoodsUser(username,name,password,sex,birthday,null,email,mobile,address,stuta);

        // 加入到数据库的用户表中
        IUserService iUserService=new UserServiceImpl();
        Boolean aBoolean = iUserService.UserAdd(goodsUser);
        System.out.println(aBoolean);
        // 成功或者失败重定向到哪里
        if (aBoolean){
            response.sendRedirect(request.getContextPath()+"/manager/admin_douserServlet");
        }
        else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('用户添加失败')");
            out.write("location.href='/manager/admin_useradd.jsp'");
            out.write("</script>");
        }
    }

}
