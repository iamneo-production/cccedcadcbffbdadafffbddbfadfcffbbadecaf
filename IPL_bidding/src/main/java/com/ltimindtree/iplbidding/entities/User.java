package com.ltimindtree.iplbidding.entities;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String role;

    // Constructors, getters, and setters

    public User() {
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters and setters
}

