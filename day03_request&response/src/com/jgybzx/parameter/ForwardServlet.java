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
 * @date: 2019/11/27 20:26
 * @Description: ${TODO}
 * @version:
 *///http:localhost:8080/
@WebServlet("/ForwardServlet")
//WebServlet(name = "ForwardServlet",urlPatterns="/ForwardServlet")
public class ForwardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//
        response.setContentType("text/html;charset=utf-8");
        //获取文本输入框的内容
        String userName = request.getParameter("userName");
        System.out.println("userName = " + userName);
        //获取单选框中的内容
        String sex = request.getParameter("sex");
        System.out.println("sex = " + sex);
        //获取checkbox 中的内容
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("Arrays.toString(hobbies) = " + Arrays.toString(hobbies));
        //获取下拉列表的内容
        String userEdu = request.getParameter("userEdu");
        System.out.println("userEdu = " + userEdu);
        //获取表单中的全部内容
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> strings = parameterMap.keySet();
        for (String string : strings) {
            System.out.println(string + "=" + Arrays.toString(parameterMap.get(string)));
        }
        People people = new People();
        try {
            BeanUtils.populate(people,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(people);
        System.out.println(request.getAttribute("user"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
