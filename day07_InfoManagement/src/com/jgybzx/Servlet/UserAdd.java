package com.jgybzx.Servlet;

import com.jgybzx.entity.User;
import com.jgybzx.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

/**
 * @author: guojy
 * @date: 2019/11/29 17:37
 * @Description: ${TODO}
 * @version:
 */
//http://localhost:8080/
@WebServlet("/UserAdd")
//WebServlet(name = "UserAdd",urlPatterns="/UserAdd")
public class UserAdd extends HttpServlet {
    private static UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题
        //接收页面传递的信息,封装到User对象中
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user= new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        user.setUserId(UUID.randomUUID().toString());
        userService.insert(user);
        response.sendRedirect(request.getContextPath()+"/UserSelect");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
