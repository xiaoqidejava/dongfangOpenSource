package com.luzhikun.servlet.home;

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
import java.util.Iterator;

/*
 * @Author liu-miss
 * @Description 查询到所有的子分类和父分类再进入index.jsp 页面
 * @Date 14:53 2021/5/30
 **/
@WebServlet(name = "IndexServlet",value = "/indexServlet")
public class IndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // 查询所有的父分类和子分类
        ICateUserService ica=new CateUserServiceImpl();
        // 查询所有的父分类
        ArrayList<Goods_Category> father = ica.selectAllCate("father");
        Iterator<Goods_Category> iterator1 = father.iterator();
        while (iterator1.hasNext()){
            Goods_Category next = iterator1.next();
            System.out.println(next);
        }
        request.setAttribute("father",father);
        System.out.println("----------------------------");
        // 查询到所有的子分类
        ArrayList<Goods_Category> child = ica.selectAllCate("child");
        Iterator<Goods_Category> iterator = child.iterator();
        while (iterator.hasNext()){
            Goods_Category next = iterator.next();
            System.out.println(next);
        }
        request.setAttribute("child",child);

        // 请求转发到首页
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
