package com.example.model;

public class User {
    private String name;
    private String lastname;
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setName(String name) {
        this.name = name;
    }
}
