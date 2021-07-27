package com.luzhikun.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * @Author liu-miss
 * @Description 检测验证码是否正确
 * @Date 17:54 2021/5/28
 **/
@WebServlet(name = "CheckUserNumServlet",value = "/checkusernum")
public class CheckUserNumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String num = request.getParameter("num");
        HttpSession session = request.getSession(false);
        String  code = (String) session.getAttribute("code");
        PrintWriter writer = response.getWriter();
        System.out.println(code);
        System.out.println(num);
        if (code.equals(num)){
            System.out.println(true);
            writer.write("true");
        }else {
            System.out.println("false");
            writer.write("false");
        }

    }
}
