package com.jgybzx.goodCookie;

import com.jgybzx.CookieUtils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: guojy
 * @date: 2019/11/28 15:05
 * @Description: 添加商品浏览记录，对应的页面     static/goods.html
 * @version:
 */
//http://localhost:8080/
@WebServlet("/addGoodsServlet")
//WebServlet(name = "addGoodsServlet",urlPatterns="/addGoodsServlet")
public class addGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题
        PrintWriter writer = response.getWriter();
        //获取商品信息
        String name = request.getParameter("name");
        //获取商品浏览记录   HISTORY的 cookie
//        Cookie[] cookies = request.getCookies();
        String goodsValue = CookieUtils.getCookie(request, "HISTORY", "utf-8");
        if(goodsValue!=null){
            //判断 名字为 goods的cookie是否已经有了这个商品
            String[] goodArr = goodsValue.split(",");
            if (!Arrays.asList(goodArr).contains(name)) {
                //如果已经存在则不再添加，如果不存在，则添加
                goodsValue+=","+name;
                CookieUtils.addCookie(request,response,"HISTORY",goodsValue,"utf-8");

            }
        }else{
            CookieUtils.addCookie(request,response,"HISTORY",name,"utf-8");
            System.out.println("第一次添加成功");
        }
        String str = "";
        str +="<div>我是商品 "+name+" 详情展示页</div>";
        str +="<a href='http://localhost:8080/day04/static/goods.html'>继续浏览商品</a><br/>";
        str +="<a href='http://localhost:8080/day04/showGoodsServlet'>查看浏览记录</a><br/>";
        writer.write(str);//响应数据
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
