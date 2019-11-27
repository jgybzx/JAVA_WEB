package com.jgybzx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author: guojy
 * @date: 2019/11/26 19:08
 * @Description: ${TODO}
 * @version:
 *///http:localhost:8080/
@WebServlet("/registerServlet")
//WebServlet(name = "registerServlet",urlPatterns="/registerServlet")
public class registerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("userName");
        String userPass = request.getParameter("userPass");
        String sex = request.getParameter("sex");
        String path = "E:/heimaIt/File的IO操作测试文件/properties.txt";
        //File file = new File(path);
        BufferedWriter out = new BufferedWriter(new FileWriter(path,true));
        String str = userName+","+userPass+","+sex;
        out.write(str);
        out.newLine();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
