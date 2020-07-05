package com.freya.entity;

import lombok.Data;

@Data
public class User {
    private String password;

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
