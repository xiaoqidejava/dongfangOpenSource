package com.luzhikun.servlet.user;

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
 * @Description 通过ajax 前端传来的username属性查找数据库是否有相同的用户名，返回 true 或者 false
 * @Date 17:57 2021/5/27

 **/
@WebServlet(name = "UserNameCheckServlet",value = "/usernameCheck")
public class UserNameCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        System.out.println(username);
        IUserService iuser=new UserServiceImpl();
        // 通过用户名查找到用户
        boolean isSucess=iuser.selectUsername(username);

        PrintWriter out = response.getWriter();
        // 判断是否找到  true 为找到 返回 false   false为 未找到 返回true
        if (isSucess){
            out.write("false");
        }else{
            out.write("true");
        }
        out.close();
    }
}
