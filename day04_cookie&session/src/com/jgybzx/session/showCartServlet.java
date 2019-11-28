package com.jgybzx.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

/**
 * @author: guojy
 * @date: 2019/11/28 16:03
 * @Description: 展示购物车
 * @version:
 */
//http://localhost:8080/
@WebServlet("/showCartServlet")
//WebServlet(name = "showCartServlet",urlPatterns="/showCartServlet")
public class showCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题
        PrintWriter writer = response.getWriter();
        writer.write("<h4>你的购物车</h4>");
        //获取session 中的数据
        Map<String,Integer> cart = (Map<String, Integer>) request.getSession().getAttribute("CART");
        String str = "<ul>";
        if(cart!=null){
            //遍历集合
            Set<String> goods = cart.keySet();
            for (String good : goods) {
                str+="<li>"+good+":"+cart.get(good)+"个</li>";
            }
        }else{
            str+="没有记录！";
        }

        str +="</ul>";
        str+="<a href='/day04/static/addCart.html'>继续添加</a>";
        writer.write(str);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
