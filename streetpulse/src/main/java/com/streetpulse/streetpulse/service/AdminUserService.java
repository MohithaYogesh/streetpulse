package com.streetpulse.streetpulse.service;

import com.streetpulse.streetpulse.model.User;
import com.streetpulse.streetpulse.model.Role;
import com.streetpulse.streetpulse.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserService {

    private final UserRepository repo;

    public AdminUserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User changeRole(Long id, String role) {
        User u = repo.findById(id).orElseThrow();
        u.setRole(Role.valueOf(role.toUpperCase()));
        return repo.save(u);
    }

    public User toggleActive(Long id) {
        User u = repo.findById(id).orElseThrow();
        u.setActive(!u.getActive());
        return repo.save(u);
    }

    // 🔴 THIS is what the controller needs
    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}

