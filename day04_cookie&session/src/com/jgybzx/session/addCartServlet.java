package com.jgybzx.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: guojy
 * @date: 2019/11/28 16:03
 * @Description: 商品添加到购物车
 * @version:
 */
//http://localhost:8080/
@WebServlet("/addCartServlet")
//WebServlet(name = "addCartServlet",urlPatterns="/addCartServlet")
public class addCartServlet extends HttpServlet {
    private static final String CART = "CART";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//解决post请求中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决response响应乱码问题
        String goodName = request.getParameter("name");
        Map<String, Integer> goodMap;
        HttpSession session = request.getSession();
        goodMap = (Map<String, Integer>) session.getAttribute(CART);//获取到session里边的属性值
        if (goodMap != null) {
            //如果不为空,说明购物车有数据，判断是否再次添加了该商品
            if (!goodMap.keySet().contains(goodName)) {
                //如果不存在则添加
                goodMap.put(goodName, 1);
            } else {//如果 已经存在，那么就数量加1
                Integer integer = goodMap.get(goodName);
                goodMap.put(goodName,++integer);
            }
        } else {
            //如果为空  将商品添加到 map
            goodMap = new HashMap<>();
            goodMap.put(goodName, 1);
        }
        session.setAttribute(CART,goodMap);
        PrintWriter writer = response.getWriter();
        String str = "";
        str+="<h4>添加成功！！</h4>";
        str+="<a href='/day04/static/addCart.html'>继续添加</a><br>";
        str+="<a href='/day04/showCartServlet'>查看购物车</a>";
        response.getWriter().write(str);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
