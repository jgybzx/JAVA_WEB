package com.jgybzx.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: guojy
 * @date: 2019/11/28 11:30
 * @Description: ${TODO}
 * @version:
 */
//http://localhost:8080/day04/AddCookieServlet
@WebServlet("/AddCookieServlet")
//WebServlet(name = "AddCookieServlet",urlPatterns="/AddCookieServlet")
public class AddCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题
        Cookie cookie = new Cookie("cookie1","cookie1");
        Cookie cookie1 = new Cookie("cookie2","cookie2");
        response.addCookie(cookie);
        response.addCookie(cookie1);
        response.getWriter().write("<a href='/day04/getCookieServlet'>取出cookie</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
