package com.jgybzx.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author: guojy
 * @date: 2019/12/5 11:53
 * @Description: 连接数据库工具包
 * @version:
 */
public class DBUtils {
    private static String url = "jdbc:mysql://localhost:3306/db2_2";
    private static String user = "root";
    private static String password = "jgybzx";

    static {
        try {
            ResourceBundle db2_2 = ResourceBundle.getBundle("db2_2");
            url = db2_2.getString("url");
            user = db2_2.getString("user");
            password = db2_2.getString("password");
        } catch (Exception e) {
            System.err.println("[警告]找到配置文件");
        }
    }
    //注册驱动,获取连接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
             connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    //关闭连接
    public static void closeConnection(Statement statement,Connection connection){
        try {
            if(statement!=null&&!statement.isClosed()){
                statement.close();
            }
            if(connection!=null&&!connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
