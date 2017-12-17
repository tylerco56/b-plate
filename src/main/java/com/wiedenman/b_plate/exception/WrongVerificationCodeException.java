package com.wiedenman.b_plate.exception;


import static java.lang.String.format;

public class WrongVerificationCodeException extends DomainException {

    public WrongVerificationCodeException(final String verificationCode) {
        super(format("Verification code %s does not match.", verificationCode));
    }

}
