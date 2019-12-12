package com.jgybzx.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: guojy
 * @date: 2019/12/6 13:52
 * @Description:
 * @version:
 */
public class MyBatisUtils {
    private static SqlSessionFactory build =null;
    static {
        try {
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
             build = sqlSessionFactoryBuilder.build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //抽取获得sqlSession的方法
    public static SqlSession openSession () {
        return build.openSession();
    }
    //释放资源
    public static void close(SqlSession sqlSession){
        sqlSession.commit();//提交事务
        sqlSession.close();//释放资源
    }
}
