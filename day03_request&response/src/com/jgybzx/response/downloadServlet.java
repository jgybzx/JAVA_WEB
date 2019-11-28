package com.jgybzx.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: guojy
 * @date: 2019/11/28 10:58
 * @Description: ${TODO}
 * @version:
 */
//http://localhost:8080/
@WebServlet("/downloadServlet")
//WebServlet(name = "downloadServlet",urlPatterns="/downloadServlet")
public class downloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题
        //获取文件名字
        String filename = request.getParameter("select");
        System.out.println("filename = " + filename);
        //获取字节输入流
        ServletContext servletContext = this.getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream("/static/img/" + filename);
        //设置响应头 为文件需要下载
        response.setContentType("application/x-download");
        //设置浏览器 编码
        String name = new String(filename.getBytes("gb2312"), "ISO8859-1");
        response.setHeader("content-disposition","attachment;filename="+name);

        //获取字节输出流
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStream,outputStream);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
