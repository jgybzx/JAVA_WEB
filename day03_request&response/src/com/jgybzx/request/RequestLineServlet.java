package com.jgybzx.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: guojy
 * @date: 2019/11/27 20:40
 * @Description: ${TODO}
 * @version:
 */
@WebServlet("/RequestLineServlet")
//WebServlet(name = "RequestLineServlet",urlPatterns="/RequestLineServlet")
public class RequestLineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//
        response.setContentType("text/html;charset=utf-8");
        //获取请求行中的 请求方式  url  uri   ip 当前项目根路径 协议
        System.out.println("Method() = " + request.getMethod());
        System.out.println("RequestURL() = " + request.getRequestURL());
        System.out.println("RequestURI() = " + request.getRequestURI());
//        System.out.println("RemoteUser() = " + request.getRemoteUser());
        System.out.println("RemoteAddr() = " + request.getRemoteAddr());
        System.out.println("ContextPath() = " + request.getContextPath());
        System.out.println("Protocol() = " + request.getProtocol());
        System.out.println("====================================");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
