package com.streetpulse.streetpulse.controller;

import com.streetpulse.streetpulse.model.User;
import com.streetpulse.streetpulse.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final UserRepository repo;

    public AuthController(UserRepository repo) {
        this.repo = repo;
    }

    // ---------- LOGIN ----------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User req) {

        User user = repo.findByEmail(req.getEmail());

        if (user == null) {
            return ResponseEntity.status(404).body("Email not found");
        }

        if (!user.getPassword().equals(req.getPassword())) {
            return ResponseEntity.status(401).body("Invalid password");
        }

        return ResponseEntity.ok(user);
    }

    // ---------- REGISTER ----------
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

        User existing = repo.findByEmail(user.getEmail());
        if (existing != null) {
            return ResponseEntity.status(409).body("Email already exists");
        }

        User saved = repo.save(user);
        return ResponseEntity.ok(saved);
    }
}

