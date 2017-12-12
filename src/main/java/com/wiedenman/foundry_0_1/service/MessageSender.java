package com.wiedenman.foundry_0_1.service;

import com.wiedenman.foundry_0_1.models.User;

public interface MessageSender {
    boolean sendCode(User user);
}
