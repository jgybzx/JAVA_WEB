package com.jgybzx.dao;

import com.jgybzx.entity.People;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: guojy
 * @date: 2019/11/26 17:13
 * @Description: 模拟从数据库获取数据
 * @version:
 */
public class getPeople {
    public List<People> getAll(){
        List<People> list = new ArrayList<>();
        People p1 = new People("张三","男",12);
        People p2 = new People("李四","男",12);
        People p3 = new People("王五","男",12);
        People p4 = new People("赵六","男",12);
        //模拟取数据
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        return list;
    }
}
