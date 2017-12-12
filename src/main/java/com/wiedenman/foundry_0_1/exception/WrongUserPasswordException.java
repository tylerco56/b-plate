package com.wiedenman.foundry_0_1.exception;

public class WrongUserPasswordException extends DomainException {

    public WrongUserPasswordException() {
        super("Wrong user/password.");
    }

}