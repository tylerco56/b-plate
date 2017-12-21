package com.wiedenman.b_plate.service;

import com.wiedenman.b_plate.exception.EmailExistsException;
import com.wiedenman.b_plate.web.model.Role;
import com.wiedenman.b_plate.web.model.User;
import com.wiedenman.b_plate.web.model.VerificationToken;
import com.wiedenman.b_plate.web.model.data.RoleDao;
import com.wiedenman.b_plate.web.model.data.UserDao;
import com.wiedenman.b_plate.web.model.data.VerificationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 *    888                      888          888
 *    888                      888          888
 *    888                      888          888
 *    88888b.         88888b.  888  8888b.  888888 .d88b.
 *    888 "88b        888 "88b 888     "88b 888   d8P  Y8b
 *    888  888 888888 888  888 888 .d888888 888   88888888
 *    888 d88P        888 d88P 888 888  888 Y88b. Y8b.
 *    88888P"         88888P"  888 "Y888888  "Y888 "Y8888
 *                    888
 *                    888
 *                    888
 *
 *
 * @author Landon Wiedenman
 * github.com/landongw/b-plate
 * Usage: or personal non-commercial use only.  Please contact me for commercial uses.
 *
 * Copyright (c) 2017 Landon Wiedenman
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private VerificationDao verificationDao;

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
    public User findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public Optional<User> findUserByResetToken(String resetToken) {
        return userDao.findByResetToken(resetToken);
    }

    @Override
    public User registerNewUser(final User newUser) throws EmailExistsException {
        if (emailExists(newUser.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: " + newUser.getEmail());
        } else {
            newUser.setRole(roleDao.findById((long) 1));
            newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
            newUser.setVerifyPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
            return userDao.save(newUser);
        }
    }

    @Override
    public void createVerificationTokenForUser(User user, String token) {
        final VerificationToken myToken = new VerificationToken(token, user);
        verificationDao.save(myToken);
    }

    @Override
    public VerificationToken getVerificationToken(String token) {
        return verificationDao.findByToken(token);
    }

    @Override
    public void saveRegisteredUser(User user) {
        userDao.save(user);
    }

    private boolean emailExists(String email) {
        final User user = userDao.findByEmail(email);
        return user != null;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }
}
