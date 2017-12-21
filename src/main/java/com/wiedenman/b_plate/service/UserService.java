package com.wiedenman.b_plate.service;

import com.wiedenman.b_plate.exception.EmailExistsException;
import com.wiedenman.b_plate.web.model.User;
import com.wiedenman.b_plate.web.model.VerificationToken;
import org.springframework.security.core.userdetails.UserDetailsService;

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

public interface UserService extends UserDetailsService{

    User findByUsername(String username);

    User findUserByEmail(String email);

    Optional<User> findUserByResetToken(String resetToken);

    User registerNewUser(User user) throws EmailExistsException;

    void createVerificationTokenForUser(User user, String token);

    VerificationToken getVerificationToken(String token);

    void saveRegisteredUser(User user);

    void save(User user);
}
