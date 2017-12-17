package com.wiedenman.b_plate.service.twilio;



import com.wiedenman.b_plate.model.User;
import com.wiedenman.b_plate.model.data.UserDao;

import javax.transaction.Transactional;

public class ConfirmUser {

    private UserDao userDao;

//    @Inject // TODO: find out how to use inject
    public ConfirmUser(final UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void confirm(final User user, final String verificationCode) {
        user.confirm(verificationCode);
        userDao.save(user);
    }
}
