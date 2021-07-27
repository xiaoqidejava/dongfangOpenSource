package com.luzhikun.servlet.product;

import com.luzhikun.domain.Goods_Product;
import com.luzhikun.service.IProductService;
import com.luzhikun.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @Author liu-miss
 * @Description 修改商品前置页面
 * @Date 22:15 2021/5/31
 **/
@WebServlet(name = "ToProductModifyServlet",value = "/manager/admin_toproductmodifyServlet")
public class ToProductModifyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取到前台传来的参数信息
        String productId = request.getParameter("id");
        // 通过id查询到此商品信息
        int id=Integer.parseInt(productId);
        IProductService ipc=new ProductServiceImpl();
        Goods_Product goods_product= ipc.selectById(id);
        System.out.println(goods_product);
        if (goods_product!=null){
            // 存到请求域中
            request.setAttribute("oneProduct",goods_product);
            // 将信息转发到修改商品页面
            request.getRequestDispatcher("/manager/admin_productModify.jsp").forward(request,response);
        }




    }
}
