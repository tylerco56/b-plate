package com.wiedenman.b_plate.exception;

import static java.lang.String.format;

/**
 *   _                       _         _
 *  | |                     | |       | |
 *  | |__    ______   _ __  | |  __ _ | |_  ___
 *  | '_ \| |______| | '_ \ | | / _` || __|/ _ \
 *  | |_) |          | |_) || || (_| || |_|  __/
 *  |_.__/           | .__/ |_| \__,_| \__|\___|
 *                   | |
 *                   |_|
 *
 * @author by Landon Wiedenman - github.com/landongw/b-plate
 *
 * License: for personal non-commercial use only.  Please contact me for commercial uses.
 *
 */

public class WrongVerificationCodeException extends DomainException {

    public WrongVerificationCodeException(final String verificationCode) {
        super(format("Verification code %s does not match.", verificationCode));
    }

}
