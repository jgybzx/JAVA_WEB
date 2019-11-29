package com.jgybzx.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: guojy
 * @date: 2019/11/29 8:20
 * @Description: 第一个过滤器
 * @version:
 */
public class myFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器启动");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("过滤器执行");
        //获取请求的url
        String s = request.getRequestURL().toString();
        System.out.println("s = " + s);
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("过滤器执行完成");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
