package com.luzhikun.servlet.cart;

import com.luzhikun.service.CartShoppServiceImpl;
import com.luzhikun.service.ICartShoppService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @Author liu-miss
 * @Description 购物车通过ajax 修改数据库中的数据
 * @Date 20:31 2021/6/2
 **/
@WebServlet(name = "CartNumAddServlet",value = "/cartnumaddServlet")
public class CartNumAddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取到购物车中的修改数据
        String count = request.getParameter("count");
        String esid = request.getParameter("esid");
        ICartShoppService ics=new CartShoppServiceImpl();

        if (count!=null && esid!=null){
           int  pcount=Integer.parseInt(count);
           int pesid=Integer.parseInt(esid);

            boolean b = ics.updateCount(pesid, pcount);
            

        }



    }
}
