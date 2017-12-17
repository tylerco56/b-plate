package com.wiedenman.b_plate.service.twilio;

import com.wiedenman.b_plate.model.User;

public interface MessageSender {
    boolean sendCode(User user);
}
