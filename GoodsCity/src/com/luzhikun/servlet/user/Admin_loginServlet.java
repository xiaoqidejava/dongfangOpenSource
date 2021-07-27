package com.luzhikun.servlet.user;

import com.luzhikun.domain.GoodsUser;
import com.luzhikun.service.IUserService;
import com.luzhikun.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
 * @Author liu-miss
 * @Description 后台管理员登录页面
 * @Date 15:30 2021/5/28
 **/
@WebServlet(name = "Admin_loginServlet",value = "/manager/adminloginServlet")
public class Admin_loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // 获取参数信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        IUserService iuser= new UserServiceImpl();
        GoodsUser goodsUser = iuser.selectUsername(username, password);
        HttpSession session=null;
        String msg=null;
        System.out.println(goodsUser);
        if (goodsUser!=null){
            // 2为管理员用户
            if (goodsUser.getUSER_STATUS() == 2){
                 session = request.getSession();
                session.setAttribute("userInfo",goodsUser);
                session.setAttribute("userLogin","1");
                session.setAttribute("isAdminLogin","1");
                response.sendRedirect(request.getContextPath()+"/manager/admin_index.jsp");
            }else {
                session=request.getSession();
                msg="对不起，您不是管理员";
                session.setAttribute("msg",msg);
                response.sendRedirect(request.getContextPath()+"/manager/login.jsp");
            }
        }else {
            session = request.getSession();
            msg="对不起,您的账号或者密码有误";
            session.setAttribute("msg",msg);
            response.sendRedirect(request.getContextPath()+"/manager/login.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
