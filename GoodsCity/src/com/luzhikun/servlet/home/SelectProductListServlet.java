package com.luzhikun.servlet.home;

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
import java.util.Iterator;

/*
 * @Author liu-miss
 * @Description 选择产品页面
 * @Date 15:32 2021/5/30
 **/
@WebServlet(name = "SelectProductListServlet",value = "/selectProductList")
public class SelectProductListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 查询所有的父分类和子分类
        ICateUserService ica=new CateUserServiceImpl();
        IProductService ips=new ProductServiceImpl();
        // 查询所有的父分类
        ArrayList<Goods_Category> father = ica.selectAllCate("father");
        request.setAttribute("father",father);

        ArrayList<Goods_Category> child = ica.selectAllCate("child");
        request.setAttribute("child",child);

        // 获取点击a标签时传来的数据获取到
        String fid = request.getParameter("fid");
        String cid = request.getParameter("cid");
        ArrayList<Goods_Product> productList=null;
        int id=0;
        if (fid!=null){
            id=Integer.parseInt(fid);
            productList=ips.selectAllByFId(id);
        }if (cid!=null){
            id=Integer.parseInt(cid);
            productList=ips.selectAllByCId(id);
        }
        Goods_Category goods_category = ica.selectCateById(id);
        request.setAttribute("title",goods_category.getCATE_NAME());
        request.setAttribute("list",productList);
        // 请求转发到首页
        request.getRequestDispatcher("/productList.jsp").forward(request,response);

    }
}
