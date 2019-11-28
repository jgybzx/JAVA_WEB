package com.jgybzx.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: guojy
 * @date: 2019/11/28 10:24
 * @Description: 响应头操作
 * @version:
 */
//http://localhost:8080/day03/requestHeard
@WebServlet("/requestHeard")
public class requestHeard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //设置响应头
//        response.setContentType("text/html;charset=utf-8");//html
//        response.setContentType("text/plain;charset=utf-8");//纯文本
//        response.setContentType("application/x-download");//文件
//        response.setHeader("content-disposition","attachment;filename=sd");//需要下载

        //设置重定向,方法一
        response.setStatus(302);
        response.setHeader("location","http://www.taobao.com");
        //方法二
        response.sendRedirect("http://www.taobao.com");
        response.getWriter().write("<h1>asd</h1>");
    }

}
