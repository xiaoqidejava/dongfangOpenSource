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

@WebServlet(name = "ToCateModifyServlet",value ="/manager/admin_tocatemodifyServlet")
public class ToCateModifyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 获取前台传来的参数信息
        String parameter_id = request.getParameter("id");
        System.out.println(parameter_id);
        int id=Integer.parseInt(parameter_id);
        System.out.println("------");
        System.out.println(id);
        ICateUserService ics=new CateUserServiceImpl();
        // 查找到所有用户
        List<Goods_Category> goodsCate = ics.getGoodsCate();
        // 将查到的所有商品添加到请求域中
        request.setAttribute("goodsCate",goodsCate);
        // 调用service层对象查找到这个商品类别的所有信息
        Goods_Category goods_category=ics.selectCateById(id);

        // 传到修改界面
        if (goods_category!=null){
            System.out.println(goods_category);
//            request.setAttribute("cate",);
            request.setAttribute("cate1",goods_category);
            request.getRequestDispatcher("/manager/admin_catemodify.jsp").forward(request,response);
        }else {

        }

    }
}
