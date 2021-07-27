package com.luzhikun.servlet.cart;

import com.luzhikun.domain.GoodsUser;
import com.luzhikun.domain.Goods_Cart;
import com.luzhikun.domain.Goods_Product;
import com.luzhikun.service.CartShoppServiceImpl;
import com.luzhikun.service.ICartShoppService;
import com.luzhikun.service.IProductService;
import com.luzhikun.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * @Author liu-miss
 * @Description 购物车添加
 * @Date 15:41 2021/6/2
 **/
@WebServlet(name = "CartAddServlet",value = "/cartadd")
public class CartAddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ICartShoppService ics=new CartShoppServiceImpl();
        IProductService ps=new ProductServiceImpl();
        Goods_Cart gc=null;

        // 获取前台参数信息
        // 商品id
        String pid = request.getParameter("id");
//        购买数量
        String count = request.getParameter("count");
        // 判断是加入购物车还是购买
        String isFlag = request.getParameter("isFlag");

        System.out.println(isFlag);

        HttpSession session = request.getSession();
        String userLogin = (String) session.getAttribute("userLogin");
        GoodsUser userInfo = (GoodsUser) session.getAttribute("userInfo");
        PrintWriter out=null;
        Goods_Product goods_product=new Goods_Product();
        if (userInfo!=null && "1".equals(userLogin)){
            // 获取用户名
            String user_id = userInfo.getUSER_ID();

            // 获取商品
            if (pid!=null){
                int productId=Integer.parseInt(pid);

                // 如果不是第一次购买商品  加数量就ok
                Goods_Cart  goods_cart= ics.selectById(user_id,productId);
                if (goods_cart!=null){
                    int cart_quantity = goods_cart.getCart_quantity();
                    int allCount = Integer.parseInt(count)+cart_quantity;
                    if (allCount>=5 ){
                        allCount=5;
                    }
                // 通过产品id 查找到此商品 并且修改其数量
                    ics.updateCount(productId,allCount);

                } else {

                    goods_product = ps.selectById(productId);
                    gc=new Goods_Cart(
                            0,
                            goods_product.getPRODUCT_FILENAME(),
                            goods_product.getPRODUCT_NAME(),
                            goods_product.getPRODUCT_PRICE(),
                            Integer.parseInt(count),
                            goods_product.getPRODUCT_STOCK(),
                            goods_product.getPRODUCT_ID(),
                            user_id,
                            1 );
                  ics.insertProductToCar(gc);
                }

            }
                if ("b".equals(isFlag)){
                    System.out.println("1111");
                    response.sendRedirect(request.getContextPath()+"/showCart");
                }else {
                    response.sendRedirect(request.getContextPath()+"/selectProView?id="+pid);
                }
            }else {

                out = response.getWriter();
                out.write("<script>");
                out.write("alert('您需要先登录')");
                out.write("location.href='/login.jsp");
                out.write("</script>");

        }

    }
}
