package com.jgybzx.entity;

import java.util.Arrays;

/**
 * @author: guojy
 * @date: 2019/11/27 20:18
 * @Description: 使用BeanUtils.populate(object, parameterMap)把名值对集合转为对象
 * @version:
 */
public class People {
    public People() {
    }
    private String userName;
    private String sex;
    private String[] hobby;
    private String userEdu;

    public People(String userName, String sex, String[] hobby, String userEdu) {
        this.userName = userName;
        this.sex = sex;
        this.hobby = hobby;
        this.userEdu = userEdu;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public String getUserEdu() {
        return userEdu;
    }

    public void setUserEdu(String userEdu) {
        this.userEdu = userEdu;
    }

    @Override
    public String toString() {
        return "People{" +
                "userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", hobby=" + Arrays.toString(hobby) +
                ", userEdu='" + userEdu + '\'' +
                '}';
    }
}
