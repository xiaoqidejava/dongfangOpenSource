package com.luzhikun.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @Author liu-miss
 * @Description 过滤恶意提交(登录时)
 * @Date 21:14 2021/5/27
 **/
@WebFilter(filterName = "LoginFilter",value = "/loginServlet")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username==null || username.trim().length()==0 || password==null || password.trim().length()==0){
            // 如果用户名或者密码为空就直接拦截  返回到登陆页面
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
        // 如果验证正确就放行
        else {
            chain.doFilter(req, resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
