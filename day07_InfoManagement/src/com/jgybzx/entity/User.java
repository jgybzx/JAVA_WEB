package com.jgybzx.entity;

/**
 * @author: guojy
 * @date: 2019/11/29 12:04
 * @Description:
 * @version:
 */
public class User {
    public User() {
    }
    private String userId;
    private String userName;
    private String userPass;
    private Integer userAge;

    public User(String userId, String userName, String userPass, Integer userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.userAge = userAge;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userAge='" + userAge + '\'' +
                '}';
    }
}
