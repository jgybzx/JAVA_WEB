package com.jgybzx.parameter;

import com.jgybzx.entity.People;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @author: guojy
 * @date: 2019/11/27 20:07
 * @Description: ${TODO}
 * @version:
 *///http:localhost:8080/
@WebServlet("/parameterServlet")
//WebServlet(name = "parameterServlet",urlPatterns="/parameterServlet")
public class parameterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//
        response.setContentType("text/html;charset=utf-8");
        System.out.println("请求转发给 ForwardServlet");
        request.getRequestDispatcher("/ForwardServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
