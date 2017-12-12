package com.wiedenman.foundry_0_1.service;

//import com.google.inject.Inject;
//import com.google.inject.persist.Transactional;
//import com.twilio.sms2fa.domain.exception.WrongUserPasswordException;
//import com.twilio.sms2fa.domain.model.User;
//import com.twilio.sms2fa.domain.repository.UserRepository;
//import com.wiedenman.foundry_0_1.exception.WrongUserPasswordException;
import com.wiedenman.foundry_0_1.exception.WrongUserPasswordException;
import com.wiedenman.foundry_0_1.models.User;
import com.wiedenman.foundry_0_1.models.data.UserDao;

import javax.transaction.Transactional;
import java.util.Optional;

public class LogIn {

    private UserDao userDao;
    private MessageSender messageSender;

//    @Inject  // TODO: figure out how to use google inject
    public LogIn(
            final UserDao userDao,
            final MessageSender messageSender) {
        this.userDao = userDao;
        this.messageSender = messageSender;
    }

    @Transactional
    public User authenticate(final String email, final String password) {
        Optional<User> userOpt = userDao.findByEmail(email);
        if (userOpt.isPresent()) {
            User user1 = userOpt.get();
            if (user1.authenticate(password)) {
                user1.generateNewVerificationCode();
                userDao.save(user1);
                messageSender.sendCode(user1);
            } else {
                throw new WrongUserPasswordException();
            }
        }
        userOpt.orElseThrow(WrongUserPasswordException::new);
        return userOpt.get();
    }
}
