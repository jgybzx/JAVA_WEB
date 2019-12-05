package com.jgybzx.jdbc;

import com.jgybzx.utils.DBUtils;
import org.junit.Test;

import java.sql.*;
import java.util.Scanner;

/**
 * @author: guojy
 * @date: 2019/12/5 15:33
 * @Description: 演示登录
 * @version:
 */
public class Login {
    public static void main(String[] args) throws SQLException {
        Login.fun1();
    }
    @Test
    public static   void fun1() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入用户名:");
        String name = scanner.nextLine();
        System.out.println("输入密码");
        String pass = scanner.nextLine();

        Connection connection = DBUtils.getConnection();
        //准备 sql语句
        String sql = " SELECT NAME,pass FROM USER WHERE NAME = ? AND pass = ?";
        //获取PreparedSatement预编译对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //设置参数
        ps.setString(1,name);
        ps.setString(2,pass);
        //直接执行,不需要再次传递 sql
        ResultSet resultSet = ps.executeQuery();
        if(resultSet.next()){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
        resultSet.close();
        ps.close();
        connection.close();
    }
    public static void fun() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入用户名:");
        String name = scanner.nextLine();
        System.out.println("输入密码");
        String pass = scanner.nextLine();

        Connection connection = DBUtils.getConnection();
        Statement statement = connection.createStatement();
        String sql = " SELECT NAME,pass FROM USER WHERE NAME = '"+name+"' AND pass = '"+pass+"' ";
        System.out.println(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next()){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
