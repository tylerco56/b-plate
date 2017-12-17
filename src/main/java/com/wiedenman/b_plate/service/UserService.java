package com.wiedenman.b_plate.service;

import com.wiedenman.b_plate.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService{
    User findByUsername(String username);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByResetToken(String resetToken);
    void save(User user);
}
