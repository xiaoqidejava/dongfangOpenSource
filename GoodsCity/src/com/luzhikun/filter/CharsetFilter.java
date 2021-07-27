package com.luzhikun.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @Author liu-miss
 * @Description 请求响应字符集
 * @Date 7:17 2021/5/25
 **/
@WebFilter(filterName = "CharsetFilter",value = "/*")
public class CharsetFilter implements Filter {
    public void destroy() { }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        request.setCharacterEncoding("UTF-8");
        System.out.println("执行了请求过滤字符集");
        chain.doFilter(request, response);
        response.setContentType("text/html;charset=UTF-8");
        String parameter = request.getParameter("goods");
        System.out.println("执行了响应过滤字符集");
        response.setCharacterEncoding("UTF-8");

    }

    public void init(FilterConfig config) throws ServletException { }

}
