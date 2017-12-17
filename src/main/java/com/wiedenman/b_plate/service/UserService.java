package com.wiedenman.b_plate.service;

import com.wiedenman.b_plate.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

//import java.util.Optional;

public interface UserService extends UserDetailsService{
    public User findByUsername(String username);
    public Optional<User> findUserByEmail(String email);
    public Optional<User> findUserByResetToken(String resetToken);
    public void save(User user);
}
