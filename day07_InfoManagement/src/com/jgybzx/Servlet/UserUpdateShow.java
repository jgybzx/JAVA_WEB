package com.jgybzx.Servlet;

import com.jgybzx.entity.User;
import com.jgybzx.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author: guojy
 * @date: 2019/11/29 17:55
 * @Description: ${TODO}
 * @version:
 */
//http://localhost:8080/
@WebServlet("/UserUpdateShow")
//WebServlet(name = "UserUpdateShow",urlPatterns="/UserUpdateShow")
public class UserUpdateShow extends HttpServlet {
    private static UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题
        String id = request.getParameter("id");
        //获取页面数据 准备展示
        User user = userService.selecctById(id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/user/UserUpdate.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
