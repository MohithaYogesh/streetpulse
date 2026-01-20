package com.streetpulse.streetpulse.repository;

import com.streetpulse.streetpulse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // ✅ REQUIRED for login & register
    User findByEmail(String email);
}
