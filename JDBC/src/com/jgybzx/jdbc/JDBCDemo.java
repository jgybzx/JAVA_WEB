package com.jgybzx.jdbc;

import com.jgybzx.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: guojy
 * @date: 2019/12/5 11:51
 * @Description: 测试连接
 * @version:
 */
public class JDBCDemo {
    public static void main(String[] args) throws SQLException {
        //获取连接
        Connection connection = DBUtils.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       /* 查询数据 并输出
       String sql = "SELECT id,ename,salary FROM  emp  WHERE id LIKE '101%'";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("=================");
            System.out.println("id= " + resultSet.getInt("id"));
            System.out.println("ename= " + resultSet.getString("ename"));
            System.out.println("salary= " + resultSet.getDouble("salary"));
        }*/
       //开启事务
        connection.setAutoCommit(false);
        try {
            String sql = " UPDATE emp SET salary= salary/0 ";
            int line = statement.executeUpdate(sql);
            System.out.println("line = " + line);
            connection.commit();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            connection.rollback();
        }
        DBUtils.closeConnection(statement,connection);
    }
}
