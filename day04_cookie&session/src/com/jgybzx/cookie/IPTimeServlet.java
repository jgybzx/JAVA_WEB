package com.jgybzx.cookie;

import com.jgybzx.CookieUtils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: guojy
 * @date: 2019/11/28 14:03
 * @Description: 获取上次浏览的 ip和时间
 * 首先从cookie中获取ip和时间，如果为空说明第一次，那么就设置本次的ip和时间
 * 否则就取出来并显示，并添加本次的 ip和时间
 * @version:
 */
//http://localhost:8080/day04/IP&TimeServlet
@WebServlet("/IP&TimeServlet")
//WebServlet(name = "IP&TimeServlet",urlPatterns="/IP&TimeServlet")
public class IPTimeServlet extends HttpServlet {
    private static  String HISTORY = "HISTORY";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题
        PrintWriter writer = response.getWriter();
        String cookie = CookieUtils.getCookie(request, "HISTORY","utf-8");
        System.out.println("cookie = " + cookie);
        String ip = null;
        String time = null;
        if (cookie != null) {
            ip = cookie.split(",")[0];
            time = cookie.split(",")[1];
        }
        writer.write("上次访问的ip:" + ip + "<br>");
        writer.write("上次访问的time:" + time);
        ip = request.getRemoteAddr();
        System.out.println("ip = " + ip);
        time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("time = " + time);
        String str = ip + "," + time;
        System.out.println("str = " + str);
//        CookieUtils.addCookie(request, response, HISTORY, str);
        CookieUtils.addCookie(request, response, "HISTORY", str, "utf-8");
        System.out.println("创建成功");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
