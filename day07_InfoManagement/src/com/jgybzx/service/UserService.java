package com.jgybzx.service;

import com.jgybzx.dao.UserDao;
import com.jgybzx.entity.User;

import java.util.List;

/**
 * @author: guojy
 * @date: 2019/11/29 14:16
 * @Description: 数据业务逻辑 处理
 * @version:
 */
public class UserService {
    private static UserDao userDao = new UserDao();

    /**
     * 业务处理 获取dao层数据
     * @return
     */
    public List<User> selectUserList(){
        return userDao.select();
    }

    /**
     * 删除
     * @param id 要删除的id
     */
    public void delete(String id){
        userDao.delete(id);
    }

    /**
     * 新增
     * @param user 要新增的对象
     */
    public void insert(User user){
        userDao.insert(user);
    }

    /**
     * 根据id得到数据，修改使用（目前）
     * @param id 用户id
     * @return
     */
    public User selecctById (String id){
        User user = userDao.selectById(id);
        return user;
    }

    /**
     * 更新
     * @param user 要更新的数据
     */
    public void update(User user){
        userDao.update(user);
    }
}
