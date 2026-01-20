package com.streetpulse.streetpulse.controller;

import com.streetpulse.streetpulse.model.User;
import com.streetpulse.streetpulse.service.AdminUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
public class AdminUserController {

    private final AdminUserService service;

    public AdminUserController(AdminUserService service) {
        this.service = service;
    }

    // GET all users
    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }

    // Change user role
    @PutMapping("/{id}/role")
    public User changeRole(@PathVariable Long id,
                           @RequestParam String role) {
        return service.changeRole(id, role);
    }

    // Activate / Deactivate user
    @PutMapping("/{id}/toggle")
    public User toggle(@PathVariable Long id) {
        return service.toggleActive(id);
    }

    // Delete user
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteUser(id);
    }
}
