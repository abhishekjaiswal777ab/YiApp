package com.example.yiapp.login;

public class LoginSend {
    String userId;
    String password;

    public LoginSend() {
    }

    public LoginSend(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
