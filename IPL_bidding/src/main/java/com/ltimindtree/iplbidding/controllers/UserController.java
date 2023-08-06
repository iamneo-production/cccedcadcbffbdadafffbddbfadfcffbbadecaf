package com.ltimindtree.iplbidding.controllers;

import com.ltimindtree.iplbidding.entities.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/api/auth/login")
    public User login(@RequestBody User loginUser) {
        // Hardcoded user credentials for demonstration purposes
        User admin = new User("admin", "admin", "ADMIN");
        User organizer = new User("organizer", "organizer", "ORGANIZER");

        // Check if the provided credentials match any hardcoded user
        if (loginUser.getUsername().equals(admin.getUsername()) && loginUser.getPassword().equals(admin.getPassword())) {
            return admin;
        } else if (loginUser.getUsername().equals(organizer.getUsername()) && loginUser.getPassword().equals(organizer.getPassword())) {
            return organizer;
        }

        // Return null if the provided credentials don't match any user
        return null;
    }
}

