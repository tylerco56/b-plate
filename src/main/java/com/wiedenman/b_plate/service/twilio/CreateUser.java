package com.wiedenman.b_plate.service.twilio;


//import com.google.inject.Inject;
//import com.google.inject.persist.Transactional;
//import com.twilio.sms2fa.domain.model.User;
//import com.twilio.sms2fa.domain.repository.UserRepository;
import com.wiedenman.b_plate.model.User;
import com.wiedenman.b_plate.model.data.UserDao;

import javax.transaction.Transactional;
import javax.validation.Valid;

public class CreateUser {

    private UserDao userDao;
    private MessageSender messageSender;

//    @Inject // TODO: find out how to user google inject
    public CreateUser(
            final UserDao userDao,
            final MessageSender messageSender) {
        this.userDao = userDao;
        this.messageSender = messageSender;
    }

    @Transactional
    public User create(@Valid final User user) {
        User savedUser = userDao.save(user);
        messageSender.sendCode(savedUser);
        return savedUser;
    }
}
