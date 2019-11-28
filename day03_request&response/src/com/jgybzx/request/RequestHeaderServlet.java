package com.jgybzx.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: guojy
 * @date: 2019/11/27 20:52
 * @Description: ${TODO}
 * @version:
 */
//http://localhost:8080/day03/RequestHeaderServlet
@WebServlet("/RequestHeaderServlet")
//WebServlet(name = "RequestHeaderServlet",urlPatterns="/RequestHeaderServlet")
public class RequestHeaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题
        PrintWriter writer = response.getWriter();
        //获取请求头中的信息
        System.out.println("request.getHeader(\"host\") = " + request.getHeader("host"));
        System.out.println("request.getHeader(\"User-Agent\") = " + request.getHeader("User-Agent"));
        System.out.println("request.getHeader(\"Content-Length\") = " + request.getHeader("Content-Length"));
        System.out.println("request.getHeader(\"Content-Type\") = " + request.getHeader("Content-Type"));
        System.out.println("request.getHeader(\"referer\") = " + request.getHeader("referer"));
        //测试防盗链  referer
        //获取 发起请求的地址，判断是不是以 http://localhost:8080 开头，如果是提示欢迎，否则提示不要脸
        String referer = request.getHeader("referer");
        if(referer.startsWith("http://localhost:8080")){
            writer.write("欢迎自家兄弟");
        }else {
            writer.write("不要脸");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
