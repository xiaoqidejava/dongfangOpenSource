package com.luzhikun.servlet.product;

import com.luzhikun.service.IProductService;
import com.luzhikun.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * @Author liu-miss
 * @Description 商品删除
 * @Date 23:19 2021/5/31
 **/
@WebServlet(name = "DoProductDeleteServlet",value = "/manager/admin_doProductDeleteServlet")
public class DoProductDeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取到前端参数信息
        String id = request.getParameter("id");
        int productId=-1;
        if (id!=null){
            productId=Integer.parseInt(id);
        }

        // 调用删除
        IProductService ip=new ProductServiceImpl();
        boolean isSuccess=ip.deleteById(productId);

        if (isSuccess){
            response.sendRedirect(request.getContextPath()+"/manager/productServlet");

        }
        else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('商品删除失败')");
            out.write("location.href='/manager/productServlet'");
            out.write("</script>");
        }


    }
}
