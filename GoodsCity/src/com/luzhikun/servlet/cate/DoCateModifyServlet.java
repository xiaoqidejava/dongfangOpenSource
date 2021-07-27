package com.luzhikun.servlet.cate;

import com.luzhikun.domain.GoodsUser;
import com.luzhikun.domain.Goods_Category;
import com.luzhikun.service.CateUserServiceImpl;
import com.luzhikun.service.ICateUserService;
import com.luzhikun.service.IUserService;
import com.luzhikun.service.UserServiceImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * @Author liu-miss
 * @Description 管理员修改商品类别
 * @Date 11:55 2021/5/30
 **/
@WebServlet(name = "DoCateModifyServlet",value = "/manager/admin_docatemodifyServlet")
public class DoCateModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        // 获取前台修改页面传来的商品类别id
        String id = request.getParameter("id");
        String className = request.getParameter("className");
        String pId = request.getParameter("parentId");

        int cateid=Integer.parseInt(id);
        int parentId= Integer.parseInt(pId);
        System.out.println(cateid);
        System.out.println(parentId);
        System.out.println(className);
        Goods_Category goods_category=new Goods_Category(cateid,className,parentId);

        // 创建service层对象执行修改操作
        ICateUserService ics=new CateUserServiceImpl();
        // 修改操作
        boolean b = ics.updateGood(goods_category);
        // 成功或者失败重定向
        if (b){
            response.sendRedirect(request.getContextPath()+"/manager/admin_cateServlet");
        }
        else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('商品类别修改失败')");
            out.write("location.href='/manager/touserupdate'");
            out.write("</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
