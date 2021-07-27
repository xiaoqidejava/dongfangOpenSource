package com.luzhikun.servlet.user;

import com.luzhikun.service.IUserService;
import com.luzhikun.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.SoundbankResource;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * @Author liu-miss
 * @Description  管理员删除用户
 * @Date 19:36 2021/5/26
 **/
@WebServlet(name = "DoUserDelServlet",value = "/manager/admin_douserdel")

public class DoUserDelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] id = request.getParameterValues("id[]");
        for (String ids : id) {
            System.out.println(ids);
        }
        System.out.println(id);
        // 创建service层对象执行修改操作
        IUserService iuse=new UserServiceImpl();
        for (int i = 0; i < id.length; i++) {
            iuse.deleteUser(id[i]);
        }
        response.sendRedirect(request.getContextPath()+"/manager/admin_douserServlet");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String cpage = request.getParameter("cpage");
        System.out.println(id);
        // 创建service层对象执行修改操作
        IUserService iuse=new UserServiceImpl();
        boolean isSuccess=iuse.deleteUser(id);
        System.out.println(isSuccess);
        if (isSuccess){
            response.sendRedirect(request.getContextPath()+"/manager/admin_douserServlet?cp="+cpage);
        }
        else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('用户删除失败')");
            out.write("location.href='/manager/admin_douserServlet?cp="+cpage+"'");
            out.write("</script>");
        }
    }
}
