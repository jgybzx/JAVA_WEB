package com.jgybzx.cookie;

import com.jgybzx.CookieUtils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: guojy
 * @date: 2019/11/28 13:53
 * @Description: ${TODO}
 * @version:
 */
//http://localhost:8080/day04/CookieUtilsServlet
@WebServlet("/CookieUtilsServlet")
//WebServlet(name = "CookieUtilsServlet",urlPatterns="/CookieUtilsServlet")
public class CookieUtilsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题
        //添加cookie
        CookieUtils.addCookie(request,response,"userName","郭江勇");
        String userName = CookieUtils.getCookie(request, "userName","utf-8");
        System.out.println("userName = " + userName);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
