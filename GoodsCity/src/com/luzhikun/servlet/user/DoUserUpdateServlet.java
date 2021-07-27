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
 * @Description 管理员修改用户表中的数据
 * @Date 8:26 2021/5/26
 **/
@WebServlet(name = "DoUserUpdateServlet",value = "/manager/admin_douserupdate")
public class DoUserUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取前台传来的修改的各字段的数据
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        String stutas = request.getParameter("userStatus");
        int stuta=1;
        if (stutas!=null){
            stuta=Integer.parseInt(stutas);
        }
        System.out.println(username);
        // 创建GoodsUser对象存放数据
        GoodsUser goodsUser=new GoodsUser(username,name,password,sex,birthday,null,email,mobile,address,stuta);

        // 创建service层对象执行修改操作
        IUserService iuse=new UserServiceImpl();
        boolean b = iuse.userUpdateById(username, goodsUser);
        System.out.println(b);
        // 成功或者失败重定向
        if (b){
            response.sendRedirect(request.getContextPath()+"/manager/admin_douserServlet?cp="+request.getParameter("cpage"));
        }
        else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('用户修改失败')");
            out.write("location.href='/manager/touserupdate?id="+username+"'");
            out.write("</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
