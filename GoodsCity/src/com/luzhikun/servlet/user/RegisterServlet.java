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
 * @Description 普通用户注册
 * @Date 19:30 2021/5/27
 **/
@WebServlet(name = "RegisterServlet",value = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
//        String stutas = request.getParameter("stutas");
        // 默认为普通用户
        int stuta=1;

        GoodsUser goodsUser=new GoodsUser(username,name,password,sex,birthday,null,email,mobile,address,stuta);

        // 加入到数据库的用户表中
        IUserService iUserService=new UserServiceImpl();
        Boolean aBoolean = iUserService.UserAdd(goodsUser);
        System.out.println(aBoolean);
        // 成功或者失败重定向到哪里
        if (aBoolean){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
        else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('用户添加失败')");
            out.write("location.href='reg.jsp'");
            out.write("</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
