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
 * @Description 验证普通用户登录
 * @Date 19:39 2021/5/27
 **/
@WebServlet(name = "LoginServlet",value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取前台传来的参数信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String msg="";
        System.out.println(username);
        System.out.println(password);
        // 查询用户信息
        IUserService iuser=new UserServiceImpl();
        GoodsUser goodsUser = iuser.selectUsername(username, password);
        System.out.println(goodsUser);
        // 判断成功或者失败
        if (goodsUser!=null){
            // 创建一个session 存储用户信息
            HttpSession session = request.getSession();
            // 将用户信息放入session域中
            session.setAttribute("userInfo",goodsUser);
            // 设置登录成功为状态值为 1
            session.setAttribute("userLogin","1");
            // 转向商城首页
            response.sendRedirect(request.getContextPath()+"/indexServlet");
        }
        else {
            msg="账号或密码输入有误";
            request.setAttribute("msg",msg);
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
