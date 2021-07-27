package com.luzhikun.servlet.user;

import com.luzhikun.domain.GoodsUser;
import com.luzhikun.service.IUserService;
import com.luzhikun.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @Author liu-miss
 * @Description 修改用户信息之前 通过删除按钮传过来的username属性查找到指定的用户信息，然后发送给执行修改的servlet类执行 修改操作
 * @Date 18:06 2021/5/27
 **/
@WebServlet(name = "ToUserUpdateServlet",value = "/manager/admin_touserupdate")
public class ToUserUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取前台传来的用户id属性
        String userId = request.getParameter("id");
        // 获取前台传来的当前页面
//      String cpage = request.getParameter("cpage");
        System.out.println(userId);

            // 创建service层对象调用查询方法
            IUserService iUserService = new UserServiceImpl();
            GoodsUser goodsUser = iUserService.selectById(userId);
            System.out.println(goodsUser);
            request.setAttribute("updateuser", goodsUser);
            request.setAttribute("cpage", request.getParameter("cpage"));
            // 将这个用户信息请求转发到修改页面
            request.getRequestDispatcher("/manager/admin_usermodify.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }
}
