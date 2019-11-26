package com.jgybzx.service;

import com.jgybzx.dao.getPeople;
import com.jgybzx.entity.People;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: guojy
 * @date: 2019/11/26 17:19
 * @Description: 模拟service层处理dao层数据
 * @version:
 */
public class handlePeople {
    private static getPeople people = new getPeople();//调用dao层
    public List<People> showPeople (){
        //模拟数据处理，取出所有人
        List<People> all = people.getAll();
        return all;
    }
}
