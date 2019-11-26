package com.jgybzx.entity;

/**
 * @author: guojy
 * @date: 2019/11/26 17:11
 * @Description: People类
 * @version:
 */
public class People {
    public People() {
    }
    private String name;
    private String sex;
    private int age;

    public People(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
