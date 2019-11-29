package com.jgybzx.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: guojy
 * @date: 2019/11/28 21:27
 * @Description: 注册驱动测试
 * @version:
 */
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        try {
//            DriverManager.registerDriver(new Driver());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/itheima","root","jgybzx");
        System.out.println(conn);
        Statement statement = conn.createStatement();
        String sql = "insert into category (cname) value ('我的表呢')";
    }
}
