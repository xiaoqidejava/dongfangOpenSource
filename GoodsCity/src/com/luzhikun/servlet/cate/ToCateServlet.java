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
 * @Description 商品分类查询
 * @Date 9:50 2021/5/30
 **/
@WebServlet(name = "ToCateServlet",value = "/manager/admin_toCateServlet")
public class ToCateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 查到所有的商品类别
        ICateUserService ics=new CateUserServiceImpl();
        List<Goods_Category> goodsCate = ics.getGoodsCate();

//        while (iterator.hasNext()){
//            Goods_Category next = iterator.next();
//            System.out.println(next);
//        }

        // 将查到的商品添加到请求域中
        request.setAttribute("goodsCate",goodsCate);
        // 用请求转发的方式将数据传输过去  到 商品类别添加界面
        request.getRequestDispatcher("/manager/admin_cateadd.jsp").forward(request,response);

    }
}
