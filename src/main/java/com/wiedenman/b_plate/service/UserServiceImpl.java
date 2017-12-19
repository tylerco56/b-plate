package com.wiedenman.b_plate.service;

import com.wiedenman.b_plate.model.PasswordResetToken;
import com.wiedenman.b_plate.model.User;
import com.wiedenman.b_plate.model.VerificationToken;
import com.wiedenman.b_plate.model.data.PasswordResetTokenDao;
import com.wiedenman.b_plate.model.data.UserDao;
import com.wiedenman.b_plate.model.data.VerificationTokenDao;
import com.wiedenman.b_plate.validation.EmailExistsException;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
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
 * Copyright (c) 2017. Landon Wiedenman.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private VerificationTokenDao verificationTokenDao;

    @Autowired
    private PasswordResetTokenDao passwordTokenDao;

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
    public User registerNewUser(final User user) throws EmailExistsException {
        if (emailExist(user.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: " + user.getEmail());
        }
        return userDao.save(user);
    }

    @Override
    public void createPasswordResetTokenForUser(User user, String token) {
        final PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordTokenDao.save(myToken);
    }


    @Override
    public PasswordResetToken getPasswordResetToken(String token) {
        return null;
    }

    @Override
    public void createVerificationTokenForUser(User user, String token) {

    }

    @Override
    public VerificationToken getVerificationToken(String token) {
        return null;
    }

    @Override
    public void saveRegisteredUser(User user) {

    }

    @Override
    public void save(User user) throws EmailExistsException {
        if (emailExist(user.getEmail())) {
            throw new EmailExistsException("There is already an account with registered to " + user.getEmail());
        }
        userDao.save(user);
    }

    private boolean emailExist(final String email) {
        final Optional<User> user = userDao.findByEmail(email);
        return user != null;
    }

    @Override
    public void changeUserPassword(User user, String password) {

    }


}
