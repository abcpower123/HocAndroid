package com.aszqsc.hocactivitiy;

public class User{
    String username;
    String Password;

    public User(String username, String password) {
        this.username = username;
        Password = password;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
