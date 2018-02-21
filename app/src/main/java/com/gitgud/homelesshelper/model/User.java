package com.gitgud.homelesshelper.model;

/**
 * Created by csaet on 2/21/2018.
 */

public class User {

    private String userName;
    private String password;
    private String email;


    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String password) {
        this.email = email;
    }
}
