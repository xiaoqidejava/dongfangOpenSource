package com.luzhikun.servlet.home;

import com.luzhikun.domain.Goods_Category;
import com.luzhikun.domain.Goods_Product;
import com.luzhikun.service.CateUserServiceImpl;
import com.luzhikun.service.ICateUserService;
import com.luzhikun.service.IProductService;
import com.luzhikun.service.ProductServiceImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * @Author liu-miss
 * @Description 查询商品详情
 * @Date 19:09 2021/6/1
 **/
@WebServlet(name = "SelectProViewServlet",value = "/selectProView")
public class SelectProViewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 查询所有的父分类和子分类
        ICateUserService ica=new CateUserServiceImpl();
        IProductService ips=new ProductServiceImpl();
        // 查询所有的父分类
        ArrayList<Goods_Category> father = ica.selectAllCate("father");
        request.setAttribute("father",father);

        ArrayList<Goods_Category> child = ica.selectAllCate("child");
        request.setAttribute("child",child);

        // 获取到前台的参数
        String productId = request.getParameter("id");

        // 获取最近访问
        HttpSession session=request.getSession();
        ArrayList<Integer> ibs = (ArrayList<Integer>) session.getAttribute("ibs");

        //
        if (ibs==null){
            ibs=new ArrayList<Integer>();

        }

        // 最多放5 个 如果多出就将第一个删除
        if (ibs.size()>= 5 ){
            ibs.remove(0);
        }

        if (productId!=null && (ibs.contains(Integer.parseInt(productId)))){
            ibs.add(Integer.parseInt(productId));
        }

        session.setAttribute("ibs",ibs);
        ibs = (ArrayList<Integer>) session.getAttribute("ibs");

        if (ibs!=null){
            ArrayList<Goods_Product> lastArrlist =ips.selectAllById(ibs);
            request.setAttribute("lastArraylist",lastArrlist);
        }


        Goods_Product goods_product=null;
        int id;
        if (productId!=null){
            id=Integer.parseInt(productId);
            goods_product = ips.selectById(id);

            if (goods_product!=null) {
                request.setAttribute("product", goods_product);

                int product_cid = goods_product.getPRODUCT_CID();
                Goods_Category goods_category = ica.selectCateById(product_cid);

                request.setAttribute("cate",goods_category);
                // 通过该商品的子id查找到所有的商品
                ArrayList<Goods_Product> goods_products = ips.selectAllByCId(product_cid);

                request.setAttribute("classlist",goods_products);
                request.getRequestDispatcher("proview.jsp").forward(request,response);
            }
        }



    }
}
