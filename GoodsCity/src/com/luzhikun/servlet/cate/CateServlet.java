package com.luzhikun.servlet.cate;

import com.luzhikun.domain.Goods_Category;
import com.luzhikun.service.CateUserServiceImpl;
import com.luzhikun.service.ICateUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/*
 * @Author liu-miss
 * @Description 分类管理
 * @Date 19:42 2021/5/29
 **/
@WebServlet(name = "CateServlet",value = "/manager/admin_cateServlet")
public class CateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 查找到所有的商品
        ICateUserService ics=new CateUserServiceImpl();
        List<Goods_Category> goodsCate = ics.getGoodsCate();
        Iterator<Goods_Category> iterator = goodsCate.iterator();

        System.out.println("查");
        while (iterator.hasNext()){
            Goods_Category next = iterator.next();
            System.out.println(next);
        }
        System.out.println("查");

        // 将查到的商品添加到请求域中
        request.setAttribute("goodsCate",goodsCate);
        // 用请求转发的方式将数据传输过去
        request.getRequestDispatcher("/manager/admin_cate.jsp").forward(request,response);


    }
}
