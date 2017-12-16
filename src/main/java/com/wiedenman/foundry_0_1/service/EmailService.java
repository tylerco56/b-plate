package com.wiedenman.foundry_0_1.service;

import org.springframework.mail.SimpleMailMessage;


public interface EmailService {
    public void sendEmail(SimpleMailMessage email);
}
