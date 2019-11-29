package com.jgybzx.Servlet;

import com.jgybzx.entity.User;
import com.jgybzx.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: guojy
 * @date: 2019/11/29 14:19
 * @Description: ${TODO}
 * @version:
 */
//http://localhost:8080/day07/UserSelect
@WebServlet("/UserSelect")
//WebServlet(name = "UserServlet",urlPatterns="/UserServlet")
public class UserSelect extends HttpServlet {
    private static UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题
        List<User> list = userService.selectUserList();
        System.out.println(list);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/user/UserSelect.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
