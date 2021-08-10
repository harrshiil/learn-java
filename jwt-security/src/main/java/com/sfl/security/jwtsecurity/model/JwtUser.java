package com.sfl.security.jwtsecurity.model;

public class JwtUser {

    private String userName;
    private long userId;
    private String role;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public long getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }
}
