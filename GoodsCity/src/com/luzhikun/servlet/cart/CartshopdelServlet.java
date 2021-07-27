package com.luzhikun.servlet.cart;

import com.luzhikun.service.CartShoppServiceImpl;
import com.luzhikun.service.ICartShoppService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartshopdelServlet",value = "/cartshopdelServlet")
public class CartshopdelServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取到购物车中的修改数据

        String esid = request.getParameter("esid");
        ICartShoppService ics=new CartShoppServiceImpl();

        if ( esid!=null){
            int pesid=Integer.parseInt(esid);

            boolean b = ics.deleteCart(pesid);

        }



    }
}
