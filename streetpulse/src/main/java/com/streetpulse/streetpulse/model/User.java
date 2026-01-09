package com.streetpulse.streetpulse.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")   // <-- VERY IMPORTANT
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")   // <-- must match DB column
    private String email;

    @Column(name = "password")   // <-- must match DB column
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")   // <-- must match DB column
    private Role role;

    // ---------- GETTERS & SETTERS ----------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}
