package com.streetpulse.streetpulse.controller;

import com.streetpulse.streetpulse.model.User;
import com.streetpulse.streetpulse.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final UserRepository repo;

    public AuthController(UserRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/login")
    public User login(@RequestBody User req) {

        User user = repo.findByEmail(req.getEmail());

        if (user == null) {
            System.out.println("Email not found");
            return null;
        }

        System.out.println("DB password: " + user.getPassword());
        System.out.println("Input password: " + req.getPassword());

        if (!user.getPassword().trim().equals(req.getPassword().trim())) {
            System.out.println("Password mismatch");
            return null;
        }

        System.out.println("Login successful for: " + user.getEmail());
        return user;
    }
    @PostMapping("/register")
    public User register(@RequestBody User user) {

        // check if email already exists
        User existing = repo.findByEmail(user.getEmail());
        if (existing != null) {
            return null;   // email already used
        }

        // save new user
        return repo.save(user);
    }


}
