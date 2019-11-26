package com.jgybzx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: guojy
 * @date: 2019/11/26 12:28
 * @Description: ${TODO}
 * @version:
 */
//http:localhost:8080/day05/ScopeServlet
@WebServlet("/ScopeServlet")
//WebServlet(name = "ScopeServlet",urlPatterns="/ScopeServlet")
public class ScopeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//
        response.setContentType("text/html;charset=utf-8");
        //设置四个域对象内容
        request.setAttribute("attr","request");
        request.getSession().setAttribute("attr","session");
        this.getServletContext().setAttribute("attr","application");
        //请求重定向
        request.getRequestDispatcher("/jsp/Scope.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
