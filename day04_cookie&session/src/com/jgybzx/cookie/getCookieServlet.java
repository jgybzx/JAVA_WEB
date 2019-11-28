package com.jgybzx.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: guojy
 * @date: 2019/11/28 11:37
 * @Description: ${TODO}
 * @version:
 */
//http://localhost:8080/day04/getCookieServlet
@WebServlet("/getCookieServlet")
//WebServlet(name = "getCookieServlet",urlPatterns="/getCookieServlet")
public class getCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题
        PrintWriter writer = response.getWriter();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            writer.write(name+";"+value+"<br>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
