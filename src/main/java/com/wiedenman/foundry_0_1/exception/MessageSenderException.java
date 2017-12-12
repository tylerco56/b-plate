package com.wiedenman.foundry_0_1.exception;

public class MessageSenderException extends DomainException {

    public MessageSenderException(final String message, final Exception e) {
        super(message, e);
    }
}
