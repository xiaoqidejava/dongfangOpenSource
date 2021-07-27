package com.luzhikun.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
 * @Author liu-miss
 * @Description 管理员退出---》管理员登录界面
 * @Date 9:00 2021/5/29
 **/
@WebServlet(name = "Admin_loginOutServlet",value = "/manager/admin_loginOutServlet")
public class Admin_loginOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取到该用户的session信息
        HttpSession session = request.getSession(false);
        session.removeAttribute("userInfo");
        session.removeAttribute("userLogin");
        session.removeAttribute("isAdminLogin");

        response.sendRedirect(request.getContextPath()+"/manager/login.jsp");


    }
}
