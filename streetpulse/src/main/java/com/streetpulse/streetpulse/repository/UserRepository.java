package com.streetpulse.streetpulse.repository;

import com.streetpulse.streetpulse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
