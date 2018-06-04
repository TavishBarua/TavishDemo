package com.demo.tavish.Model;

public class UserModel {

private String Name;
private String Password;

    public UserModel() {
    }

    public UserModel(String name, String password) {
        Name = name;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
