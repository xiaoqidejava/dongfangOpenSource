package com.luzhikun.servlet.cart;

import com.luzhikun.domain.GoodsUser;
import com.luzhikun.domain.Goods_Cart;
import com.luzhikun.service.CartShoppServiceImpl;
import com.luzhikun.service.ICartShoppService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * @Author liu-miss
 * @Description 购物车结算页面
 * @Date 22:04 2021/6/2
 **/
@WebServlet(name = "OrderServletServlet",value = "/orderServlet")
public class OrderServletServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ICartShoppService ics=new CartShoppServiceImpl();
        // 获取到前端数据
        HttpSession session = request.getSession();
        String userLogin = (String) session.getAttribute("userLogin");
        GoodsUser userInfo = (GoodsUser) session.getAttribute("userInfo");
        PrintWriter out=null;
        // 如果用户是登录状态
        if (userInfo != null && "1".equals(userLogin)) {

            // 总价
            int allMoney=0;
            String parameter = request.getParameter("eids");
            String[] split = parameter.split(",");
            // 通过id查找到商品集合
            ArrayList<Goods_Cart> cartList=new ArrayList<>();
            for (int i = 0; i < split.length; i++) {

               Goods_Cart goods_cart= ics.getOneCart(Integer.parseInt(split[i]));
               // 小计
                int smallMoney=goods_cart.getCart_p_price() * goods_cart.getCart_quantity();
                allMoney+=smallMoney;
               cartList.add(goods_cart);
            }

            Iterator<Goods_Cart> iterator = cartList.iterator();
            while (iterator.hasNext()){
                Goods_Cart next = iterator.next();
                System.out.println(next);
            }
            // 商品总价
            request.setAttribute("allMoney",allMoney);
            request.setAttribute("shopList",cartList);
            request.getRequestDispatcher("order.jsp").forward(request,response);

        }else {
            out = response.getWriter();
            out.write("<script>");
            out.write("alert('您需要先登录')");
            out.write("location.href='/login.jsp");
            out.write("</script>");
        }

    }
}
