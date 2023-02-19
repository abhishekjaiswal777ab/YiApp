package com.example.yiapp.login;

public class LoginResponse {
    String statusText;
    String token;

    public LoginResponse() {
    }

    public LoginResponse(String statusText, String token) {
        this.statusText = statusText;
        this.token = token;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
