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

/*
 * @Author liu-miss
 * @Description 购物车购买页面
 * @Date 15:15 2021/6/2
 **/
@WebServlet(name = "ShowCartServlet",value ="/showCart" )
public class ShowCartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ICartShoppService ics=new CartShoppServiceImpl();
        HttpSession session = request.getSession();
        String userLogin = (String) session.getAttribute("userLogin");
        GoodsUser userInfo = (GoodsUser) session.getAttribute("userInfo");
        PrintWriter out=null;
        if (userInfo != null && "1".equals(userLogin)){
            // 获取用户名
            String user_id = userInfo.getUSER_ID();
            ArrayList<Goods_Cart> cartList  = ics.getCart(user_id);
            // 将购物车记录保存在请求域中
            request.setAttribute("cartList",cartList);
            request.getRequestDispatcher("cart.jsp").forward(request,response);
        }else {
            out = response.getWriter();
            out.write("<script>");
            out.write("alert('您需要先登录')");
            out.write("location.href='/login.jsp");
            out.write("</script>");
        }


    }
}
