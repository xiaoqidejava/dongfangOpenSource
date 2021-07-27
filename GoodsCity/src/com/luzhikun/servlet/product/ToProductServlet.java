package com.luzhikun.servlet.product;

import com.luzhikun.domain.Goods_Category;
import com.luzhikun.service.CateUserServiceImpl;
import com.luzhikun.service.ICateUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/*
 * @Author liu-miss
 * @Description 商品添加前置页面
 * @Date 16:37 2021/5/30
 **/
@WebServlet(name = "ToProductServlet",value = "/manager/admin_toProductAdd")
public class ToProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 查询所有的父分类和子分类
        ICateUserService ica=new CateUserServiceImpl();
        // 查询所有的父分类
        ArrayList<Goods_Category> father = ica.selectAllCate("father");
        request.setAttribute("father",father);

        ArrayList<Goods_Category> child = ica.selectAllCate("child");
        request.setAttribute("child",child);

        request.getRequestDispatcher("/manager/admin_productadd.jsp").forward(request,response);

    }
}
