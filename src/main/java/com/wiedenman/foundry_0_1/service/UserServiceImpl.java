package com.wiedenman.foundry_0_1.service;

import com.wiedenman.foundry_0_1.model.User;
import com.wiedenman.foundry_0_1.model.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Load user from db (throw if not found)
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Return user object
        return user;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public Optional<User> findUserByResetToken(String resetToken) {
        return userDao.findByResetToken(resetToken);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }
}
