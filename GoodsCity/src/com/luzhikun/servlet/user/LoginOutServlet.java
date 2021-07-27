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
 * @Description 用户退出功能
 * @Date 15:15 2021/5/28
 **/
@WebServlet(name = "LoginOutServlet",value = "/loginOutServlet")
public class LoginOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取到这个session
        HttpSession session = request.getSession(false);
        session.removeAttribute("userInfo");
        session.removeAttribute("userLogin");

        response.sendRedirect(request.getContextPath()+"/index.jsp");

    }
}
