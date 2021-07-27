package com.luzhikun.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
 * @Author liu-miss
 * @Description 如果用户绕过表单提交信息，通过这个过滤器进行拦截
 * @Date 19:57 2021/5/27
 **/
@WebFilter(filterName = "RegisterFilter",value = "/registerServlet")
public class RegisterFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;

        String username = request.getParameter("username");
        String veryCode = request.getParameter("veryCode");

        HttpSession session = request.getSession(false);

        String  code = (String) session.getAttribute("code");
        System.out.println(code);
        System.out.println(veryCode);
        if ( username == null || username.trim().length()==0 || !code.equals(veryCode)){
            // 重新定位到注册页面
            response.sendRedirect(request.getContextPath()+"/reg.jsp");
        }
        // 如果不是的话就放行
        else {
            chain.doFilter(request, response);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
