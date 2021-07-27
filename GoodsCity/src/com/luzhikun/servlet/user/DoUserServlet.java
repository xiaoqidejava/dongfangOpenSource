package com.luzhikun.servlet.user;

import com.luzhikun.domain.GoodsUser;
import com.luzhikun.service.IUserService;
import com.luzhikun.service.UserServiceImpl;
import com.sun.org.apache.bcel.internal.generic.IUSHR;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/*
 * @Author liu-miss
 * @Description 用户管理页面 （实现用户管理界面的分页、查询所有记录、）
 * @Date 11:08 2021/5/25
 **/
@WebServlet(name = "DoUserServlet",value = "/manager/admin_douserServlet")
public class DoUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建Service层对象
        IUserService iUserService=new UserServiceImpl();

        // 当前页计数器
        int cpage=1;  // 当前第一页默认

        int count=5; // 每页显示多少数据

        // 获取用户指定的页面
        String cp = request.getParameter("cp");

        // 获取用户搜索的关键字
        String keywords=request.getParameter("keywords");

        System.out.println(keywords);
//        if (keywords==null){
//            keywords="";
//        }
        if (cp!=null){
            cpage=Integer.parseInt(cp);
            if (cpage<=0){
                cpage=1;
            }
        }

        int arr[]=iUserService.totalPage(count,keywords);

        // 查询所有用户
        ArrayList<GoodsUser> users=iUserService.selectAll(cpage,count,keywords);

        // 将所有用户放在请求域中
        request.setAttribute("userList",users);
        // 将查询到的总记录数放在请求域中
        request.setAttribute("tsum",arr[0]);
        // 将分的页数放在请求域中
        request.setAttribute("tpage",arr[1]);
        // 用户指定的当前页数
        request.setAttribute("cpage",cpage);

        if (keywords!=null){
            request.setAttribute("searchParams","&keywords="+keywords);
        }
        // 请求转发(可以携带参数)
        request.getRequestDispatcher("/manager/admin_user.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
