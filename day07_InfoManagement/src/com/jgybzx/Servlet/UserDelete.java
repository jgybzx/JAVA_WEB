package com.jgybzx.Servlet;

import com.jgybzx.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: guojy
 * @date: 2019/11/29 17:25
 * @Description: ${TODO}
 * @version:
 */
//http://localhost:8080/
@WebServlet("/UserDelete")
//WebServlet(name = "UserDelete",urlPatterns="/UserDelete")
public class UserDelete extends HttpServlet {
    private static UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题
        String id = request.getParameter("id");
        userService.delete(id);

        response.sendRedirect(request.getContextPath() + "/UserSelect");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
