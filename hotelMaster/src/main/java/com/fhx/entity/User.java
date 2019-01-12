package com.fhx.entity;

public class User {
    public final static int ROLE_USER=0;//用户
    public final static int ROLE_MANAGER=1;//员工
    public final static int ROLE_ADMIN=2;//管理人员
    protected int role;
    protected String username;
    protected String password;
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "role=" + role +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
