package com.wiedenman.foundry_0_1.exception;


import static java.lang.String.format;

public class WrongVerificationCodeException extends DomainException {

    public WrongVerificationCodeException(final String verificationCode) {
        super(format("Verification code %s does not match.", verificationCode));
    }

}
