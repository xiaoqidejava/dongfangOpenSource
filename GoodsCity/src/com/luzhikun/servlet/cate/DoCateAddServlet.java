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

/*
 * @Author liu-miss
 * @Description 做商品类别添加
 * @Date 10:27 2021/5/30
 **/
@WebServlet(name = "DoCateAddServlet",value = "/manager/admin_docateaddServlet")
public class DoCateAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 获取到前台参数信息
        int parentId = Integer.parseInt(request.getParameter("parentId"));
        String className = request.getParameter("className");

        System.out.println(parentId);
        System.out.println(className);

        Goods_Category gcg=new Goods_Category(0,className,parentId);

        ICateUserService ics=new CateUserServiceImpl();
        boolean b = ics.goodsAdd(gcg);

        if (b){
            response.sendRedirect(request.getContextPath()+"/manager/admin_cateServlet");
        }else {
            response.sendRedirect(request.getContextPath()+"/manager/admin_cateadd.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
