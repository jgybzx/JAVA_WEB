package com.impl.test;

import com.jgybzx.Utils.MyBatisUtils;
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
    @Test
    public void select() throws Exception {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession();

        List<User> user = sqlSession.selectList("userMapper.findUserAll");
        for (User user1 : user) {
            System.out.println(user1);
        }
        sqlSession.close();
    }

    @Test
    public void insert() throws Exception {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession();
        User user = new User();
        user.setUsername("jgybzx");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("山东");
        int insert = sqlSession.insert("userMapper.insertUser", user);
        System.out.println("insert = " + insert);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void update() throws IOException {
        SqlSession sqlSession = MyBatisUtils.openSession();

        //准备要修改的数据
        User user = new User();
        user.setId(50);//根据id找到数据修改
        user.setSex("女");
        user.setBirthday(new Date());
        user.setUsername("将光阴比作夏");
        user.setAddress("上海");
        sqlSession.update("userMapper.updateUser",user);
        MyBatisUtils.close(sqlSession);
    }

    @Test
    public void delete(){
        SqlSession sqlSession = MyBatisUtils.openSession();


        sqlSession.delete("userMapper.deleteUser",50);
        MyBatisUtils.close(sqlSession);
    }

    @Test
    public void selectById(){
        SqlSession sqlSession = MyBatisUtils.openSession();

        User user = sqlSession.selectOne("userMapper.selectOneUser",48);
        System.out.println("user = " + user);
        MyBatisUtils.close(sqlSession);
    }
}
