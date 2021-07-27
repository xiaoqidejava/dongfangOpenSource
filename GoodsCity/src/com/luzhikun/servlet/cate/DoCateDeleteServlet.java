package com.luzhikun.servlet.cate;

import com.luzhikun.service.CateUserServiceImpl;
import com.luzhikun.service.ICateUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * @Author liu-miss
 * @Description 商品类别删除
 * @Date 13:24 2021/5/30
 **/
@WebServlet(name = "DoCateDeleteServlet",value = "/manager/admin_docateDeleteServlet")
public class DoCateDeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        // 获取到前台传来的参数信息
        String cateId = request.getParameter("id");
        // 执行删除操作
        ICateUserService ics=new CateUserServiceImpl();
        boolean isTure=ics.deleteGood(cateId);
        PrintWriter out=response.getWriter();
        // 判断是否删除成功
        if (isTure){
            response.sendRedirect(request.getContextPath()+"/manager/admin_cateServlet");
        }
        // 如果没有成功
        else {
            out.write("<script>");
            out.write("alert('商品类别删除失败')");
            out.write("location.href='/manager/admin_cateServlet'");
            out.write("</script>");

        }


    }
}
