package com.jgybzx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: guojy
 * @date: 2019/11/26 18:27
 * @Description: ${TODO}
 * @version:
 *///http:localhost:8080/
@WebServlet("/LoginServlet")
//WebServlet(name = "LoginServlet",urlPatterns="/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String userName = request.getParameter("userName");
        String userPass = request.getParameter("userPass");
        String path = "E:/heimaIt/File的IO操作测试文件/properties.txt";
        BufferedReader in  =new BufferedReader(new FileReader(path));
        String str =null;
       // Map<String,String> map = new HashMap<>();
        while ((str=in.readLine())!=null){
            String name = str.split(",")[0];
            String pass = str.split(",")[1];
           // map.put(name,pass);
            if(name.equals(userName)&&pass.equals(userPass)){
                writer.write(userName+"你好");
                return;
            }
        }
        writer.write("<a href='/day03/static/Login.html'>密码不对，重新登录</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
