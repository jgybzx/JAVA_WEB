package com.jgybzx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: guojy
 * @date: 2019/11/26 20:34
 * @Description: ${TODO}
 * @version:
 *///http:localhost:8080/
@WebServlet("/LoginServlet")
//WebServlet(name = "LoginServlet",urlPatterns="/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//
        response.setContentType("text/html;charset=utf-8");
        //判断是否登陆成功
        PrintWriter writer = response.getWriter();
        String userName = request.getParameter("userName");
        String userPass = request.getParameter("userPass");

        System.out.println("userName = " + userName);
        System.out.println("userPass = " + userPass);
        if (!("jack".equals(userName) && "123".equals(userPass))) {
            writer.write("<a href='/day05/jsp/Login.jsp'>密码错误请重新登录</a>");
        } else {
            writer.write("你好" + userName);
            //登录成功之后，判断是否勾选记住密码,如果勾选了，那么在请求中应该会有值
            String remember = (String) request.getParameter("remember");
            if(null!=remember){
                //将 userName 设置到cookie中  起名
                Cookie cookie = new Cookie("userCookie",userName);
                cookie.setMaxAge(7*24*60*60);
                cookie.setPath(request.getContextPath()+"/jsp/Login.jsp");
                response.addCookie(cookie);
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
