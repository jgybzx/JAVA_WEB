package com.jgybzx.goodCookie;

import com.jgybzx.CookieUtils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: guojy
 * @date: 2019/11/28 15:06
 * @Description: 获取cookie的值 进行展示
 * @version:
 */

/**
 * 思路
 * 定义常量 HISTORY 作为cookie的  name
 *  获取每次点击 a 标签的 name 作为 cookie的 value
 *  每次点击浏览，都把name用逗号拼接起来
 *      1、String goods=request.getCookie(HISTORY)，获得浏览记录（此处使用自己编写的CookieUtils工具类）
 *      2、判断   浏览记录是否为空
 *          如果 空  则直接把 本次获取到的值 添加 进去
 *          如果不为空，那么就需要判断，是否已经浏览过 本次 商品
 *      把  goods  根据 逗号分隔   然后转化为一个list，使用 list.contains,判断 是否已经浏览过
 *          如果不存在那么才加入，利用 逗号拼接
 *              判断之后把内容再次添加到 cookie中，此时为覆盖
 */
//http://localhost:8080/
@WebServlet("/showGoodsServlet")
//WebServlet(name = "showGoodsServlet",urlPatterns="/showGoodsServlet")
public class showGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题
        PrintWriter writer = response.getWriter();
        //获取浏览记录 HISTORY 的cookie
        String history = CookieUtils.getCookie(request, "HISTORY", "utf-8");
        writer.write("<h1>商品浏览记录</h1>");
        for (String s : history.split(",")) {
            writer.write("<div>" + s + "</div>");
        }
        String str = "";
        str += "<div><a href='/day04/static/goods.html'>继续浏览</a></div>";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
