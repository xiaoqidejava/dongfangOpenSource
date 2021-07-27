package com.luzhikun.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * @Author liu-miss
 * @Description 管理员登录过滤器
 * @Date 17:59 2021/5/28
 **/
/*拦截所有以manager开头的请求*/
@WebFilter(filterName = "AdminLoginFilter",value = "/manager/*")
public class AdminLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        // 获取请求的地址
        String requestURI = request.getRequestURI();

        HttpSession session = request.getSession();
        String isAdminLogin1 = (String) session.getAttribute("isAdminLogin");
        System.out.println("------------");
        System.out.println(isAdminLogin1);
        System.out.println("-------------");
        String contextPath = request.getContextPath();
        String uri= requestURI.substring(contextPath.length());
        // /GoodsCity/manager/login.jsp
//        System.out.println(requestURI);
//        // /GoodsCity
//        System.out.println(contextPath);
//        // null
//        System.out.println(isAdminLogin1);
//       // /manager/login.jsp
//        System.out.println(uri);

        // 先判断是否以admin_路径访问的
        if (uri.contains("admin_")){
            // 如果session中有数据，并且状态码为2 就证明是管理员 放行
            if (isAdminLogin1 != null && isAdminLogin1 == "1" ){
                    chain.doFilter(request,response);
                    return;
                    // 如果不是就返回登录界面
            }else if (isAdminLogin1 == null || isAdminLogin1 != "1"){
                PrintWriter out = response.getWriter();
                out.write("<script>");
                out.write("alert('请先登录！')");
                out.write("location.href='/manager/login.jsp'");
                out.write("</script>");
            }
            // 如果不是以 admin_路径访问的请求 都放行
        }else {
            chain.doFilter(request,response);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
