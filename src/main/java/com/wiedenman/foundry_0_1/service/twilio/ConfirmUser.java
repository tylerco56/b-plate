package com.wiedenman.foundry_0_1.service.twilio;


//import com.google.inject.Inject;
//import com.google.inject.persist.Transactional;
//import com.twilio.sms2fa.domain.model.User;
//import com.twilio.sms2fa.domain.repository.UserRepository;
import com.wiedenman.foundry_0_1.model.User;
import com.wiedenman.foundry_0_1.model.data.UserDao;

import javax.transaction.Transactional;

public class ConfirmUser {

    private UserDao userDao;

//    @Inject // TODO: find out how to use inject
    public ConfirmUser(final UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional // TODO: find out how to use transactional and double check the chosen dependency
    public void confirm(final User user, final String verificationCode) {
        user.confirm(verificationCode);
        userDao.save(user);
    }
}
