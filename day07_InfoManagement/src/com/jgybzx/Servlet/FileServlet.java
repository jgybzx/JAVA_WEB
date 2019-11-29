package com.jgybzx.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

/**
 * @author: guojy
 * @date: 2019/11/29 19:44
 * @Description: 文件上传
 * 知识点：1、form表单提交必须是post，enctype必须是 multipart
 *          2、servlet 必须添加 @MultipartConfig注解
 *          可以在请求参数中 获取到 Content-Disposition，
 *          Content-Disposition: form-data; name="myFile"; filename="Intelij IDEAå¿«æ·é®å¤§å¨.txt"
 *          （中文名字浏览器会有乱码，但是在Servlet中已经设置了字符集，所以最后 还是中文）
 *          从而获取到文件的名字，（先以分号分隔，得到的数据再以等号分隔，最后的数据去掉前后引号）
 * @version:
 */
//http://localhost:8080/
@WebServlet("/FileServlet")
@MultipartConfig
//WebServlet(name = "FileServlet",urlPatterns="/FileServlet")
public class FileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题
        String myDesc = request.getParameter("myDesc");
        //获取文件字节流
        Part myFile = request.getPart("myFile");
        //获取文件名字 header = form-data; name="myFile"; filename="html实体字符.png"
        String header = myFile.getHeader("Content-Disposition");
        String filename = header.split(";")[2].split("=")[1].replace("\"", "");
        //获取guid 拼接给文件名字，防止同名文件被覆盖
        filename = UUID.randomUUID() + filename;
        this.getServletContext().setAttribute("filename",filename);
        //把文件写入服务器磁盘
        //myFile.write("E:\\heimaIt\\JavaSE就业\\FileIO操作目录\\服务器文件上传（requset）/" + filename);
        myFile.write(this.getServletContext().getRealPath("/static/img/"+filename));
        response.getWriter().write("<h3>【文件上传成功】</h3><a href='/day07/UserSelect'>返回</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
