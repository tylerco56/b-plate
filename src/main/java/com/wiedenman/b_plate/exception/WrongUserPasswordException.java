package com.wiedenman.b_plate.exception;

public class WrongUserPasswordException extends DomainException {

    public WrongUserPasswordException() {
        super("Wrong user/password.");
    }

}