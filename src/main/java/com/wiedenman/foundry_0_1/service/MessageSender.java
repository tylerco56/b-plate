package com.wiedenman.foundry_0_1.service;

import com.wiedenman.foundry_0_1.model.User;

public interface MessageSender {
    boolean sendCode(User user);
}
