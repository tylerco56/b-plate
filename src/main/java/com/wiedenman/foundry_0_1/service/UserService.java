package com.wiedenman.foundry_0_1.service;

import com.wiedenman.foundry_0_1.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

//import java.util.Optional;

public interface UserService extends UserDetailsService{
    User findByUsername(String username);
}
