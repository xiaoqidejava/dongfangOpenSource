package com.luzhikun.servlet.product;

import com.luzhikun.domain.Goods_Category;
import com.luzhikun.domain.Goods_Product;
import com.luzhikun.service.CateUserServiceImpl;
import com.luzhikun.service.ICateUserService;
import com.luzhikun.service.IProductService;
import com.luzhikun.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * @Author liu-miss
 * @Description 商品管理列表打开之前先进入此界面对所有商品进行查询然后将数据转到jsp页面
 * @Date 19:40 2021/5/31
 **/
@WebServlet(name = "ProductServlet",value = "/manager/productServlet")
public class ProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 查询所有的商品
        IProductService ipc=new ProductServiceImpl();
        List<Goods_Product> goods_products = ipc.selectAll();
        // 存储到请求域中
        request.setAttribute("good_products",goods_products);
        request.getRequestDispatcher("/manager/admin_product.jsp").forward(request, response);

    }
}
