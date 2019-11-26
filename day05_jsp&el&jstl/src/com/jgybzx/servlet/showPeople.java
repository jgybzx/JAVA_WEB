package com.jgybzx.servlet;

import com.jgybzx.entity.People;
import com.jgybzx.service.handlePeople;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: guojy
 * @date: 2019/11/26 17:29
 * @Description: ${TODO}
 * @version:
 *///http:localhost:8080/day05/showPeople
@WebServlet("/showPeople")
//WebServlet(name = "showPeople",urlPatterns="/showPeople")
public class showPeople extends HttpServlet {
    private static handlePeople handlePeople = new handlePeople();//调用service层
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//
        response.setContentType("text/html;charset=utf-8");

        List<People> people = handlePeople.showPeople();
        request.setAttribute("people",people);
        request.getRequestDispatcher("/jsp/showPeople.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
