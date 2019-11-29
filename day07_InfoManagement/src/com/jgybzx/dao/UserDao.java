package com.jgybzx.dao;

import com.jgybzx.Utils.DataUtil;
import com.jgybzx.entity.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: guojy
 * @date: 2019/11/29 12:28
 * @Description: 获取数据
 * @version:
 */
public class UserDao {
    private static String path = "E:\\heimaIt\\JavaSE就业\\FileIO操作目录\\三层架构用户信息展示\\Info.txt";
    private List<User> get(){
        List<User> list = DataUtil.readList(path, User.class);
        return list;
    }
    private void set(List<User> list){
        DataUtil.writeList(path,list);
    }
    //增
    public void insert(User user){
        List<User> list = this.get();
        list.add(user);
        this.set(list);
    }
    //删
    public void  delete(String id){
        List<User> list = this.get();
        list.removeIf(user -> user.getUserId().equals(id));
        this.set(list);
    }
    //改
    public void update(User user){
        List<User> list = this.get();
        list = list.stream().map(u ->u.getUserId().equals(user.getUserId())?user:u).collect(Collectors.toList());
        this.set(list);
    }
    //查全部
    public List<User> select(){
        List<User> list = this.get();
        return list;
    }
    //根据id查
    public User selectById(String id){
        List<User> list = this.get();
        User user1 = list.stream().filter(user -> user.getUserId().equals(id)).findFirst().orElse(null);
        return  user1;
    }
}
