package com.jgybzx.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jgybzx.entity.User;
import jdk.nashorn.internal.ir.CallNode;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: guojy
 * @date: 2019/11/29 10:19
 * @Description: 任何对象的文件读写操作
 * @version:
 */
public class DataUtil {
    private static ObjectMapper jackson = new ObjectMapper(); //object对象转String
    private static final String ENCODING = "UTF-8";
    private static String path = "E:\\heimaIt\\JavaSE就业\\FileIO操作目录\\三层架构用户信息展示\\Info.txt";

    /**
     * 添加集合到文件中
     *
     * @param path 文件路径
     * @param list 集合数据
     */
    public static void writeList(String path, List list) {
        try {
            String objStr = jackson.writeValueAsString(list);
            FileUtils.writeStringToFile(new File(path), objStr, ENCODING);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从文件中读取数据 转化为list
     *
     * @param path 文件地址
     * @param cla  文件内容对应的数据类型
     * @return
     */
    public static <T> List<T> readList(String path, Class<T> cla) {
        List<T> list = null;
        try {
            String objStr = FileUtils.readFileToString(new File(path), ENCODING);
            //预期文件中集合数据的类型
            JavaType javaType = jackson.getTypeFactory().constructParametricType(List.class, cla);
            list = jackson.readValue(objStr, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Test  //测试新增
    public void add() {
        List<User> list = new ArrayList<>();
        //先读出文件中的内容
        DataUtil.readList(path,User.class);
        list.add(new User("1","jgybzx","123",12));
        list.add(new User("2","大大卡司","123",12));
        list.add(new User("3","将光阴比作夏","123",12));
        DataUtil.writeList(path,list);
        System.out.println("添加成功");
    }
    @Test//测试修改
    public void update(){
        //要修改的数据
        User user = new User("1", "jgybzx修改", "123", 12);
        //从文件查数据
        List<User> list = DataUtil.readList(path, User.class);
        //判断是否有这个 数据并修改，使用Stream
        list=list.stream().map(u->u.getUserId().equals(user.getUserId())?user:u).collect(Collectors.toList());
        //写入数据
        DataUtil.writeList(path,list);
        System.out.println("修改成功");
    }
    @Test //测试删除
    public void delete(){
        //删除需要有id
        String id= "1";
        //取出数据
        List<User> list = DataUtil.readList(path,User.class);
        //删除数据  removeif
        list.removeIf(user -> user.getUserId().equals(id));
        //写回文件
        DataUtil.writeList(path,list);
        System.out.println("删除 成功");
    }
    @Test //查询所有数据
    public void selectAll(){
        List<User> list = DataUtil.readList(path, User.class);
        System.out.println(list);
    }
    @Test //查询一条数据
    public void selectById(){
        String id = "2";
        List<User> list = DataUtil.readList(path, User.class);
        User user1 = list.stream().filter(user -> user.getUserId().equals(id)).findFirst().orElse(null);
        System.out.println(user1);
    }
}
