package com.jgybzx.dao;

import com.jgybzx.domain.User;

/**
 * @author: guojy
 * @date: 2019/12/6 15:28
 * @Description:
 * @version:
 */
public interface UserDao {
    public void insert(User user);
    public void update(User user);
    public void delete(String id);
}
