package com.jgybzx.test;

import com.jgybzx.Utils.MyBatisUtils;
import com.jgybzx.dao.UserDao;
import com.jgybzx.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author: guojy
 * @date: 2019/12/6 12:01
 * @Description: 测试类
 * @version:
 */
public class TsetDeom {
    @Test//insert
    public void insert() throws Exception {
        SqlSession sqlSession = MyBatisUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user =new User();
        user.setUsername("12");
        user.setAddress("12");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.insert(user);
        MyBatisUtils.close(sqlSession);
    }
    @Test //update
    public void update(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        

    }
}


