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

@WebServlet(name = "DoProductModifyServlet",value = "/manager/admin_doProductModifyServlet")
public class DoProductModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取到前端传来的参数信息
        String productId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        String productPrice = request.getParameter("productPrice");
        String productdesc = request.getParameter("productdesc");
        String productStock = request.getParameter("productStock");
        System.out.println(productId);
        System.out.println(productName);
        System.out.println(productPrice);
        System.out.println(productdesc);
        System.out.println(productStock);
        int id=0;
        int price=0;
        int stock=0;
        if (productId!=null){
            id=Integer.parseInt(productId);
        }
        if (productPrice!=null){
            price=Integer.parseInt(productPrice);
        }
        if (productStock!=null){
            stock=Integer.parseInt(productStock);
        }

        // 通过id修改这些属性
        IProductService ips=new ProductServiceImpl();
        boolean isTrue=ips.updateProduct(id,productName,price,productdesc,stock);
        System.out.println(isTrue);
        // 成功或失败
        if (isTrue){
            response.sendRedirect(request.getContextPath()+"/manager/productServlet");
        }
        else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('商品修改失败')");
            out.write("location.href='/manager/admin_toproductmodifyServlet'");
            out.write("</script>");
        }


    }

}
