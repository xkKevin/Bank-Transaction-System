package com.XK.Bean;

public class UserBean {
    private String username;//用户名
    private String password;//密码都是与数据库匹配的，下面是set和get函数
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
