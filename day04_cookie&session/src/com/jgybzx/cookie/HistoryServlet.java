package com.jgybzx.cookie;

import com.jgybzx.CookieUtils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: guojy
 * @date: 2019/11/28 14:54
 * @Description: ${TODO}
 * @version:
 */
//http://localhost:8080/day04/HistoryServlet
@WebServlet("/HistoryServlet")
//WebServlet(name = "HistoryServlet",urlPatterns="/HistoryServlet")
public class HistoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题
        PrintWriter writer = response.getWriter();
        //获取历史数据  HISTORY
        String history = CookieUtils.getCookie(request, "HISTORY", "utf-8");
        if(history==null){
            writer.write("第一次访问");
        }else{
            writer.write("ip:"+history.split("&")[0]+"");
            writer.write("time:"+history.split("&")[1]);
        }
        String str = "";
        String ip = request.getRemoteAddr();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        str = ip + "&" + time;
        //设置数据
        CookieUtils.addCookie(request, response, "HISTORY", str, "utf-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
