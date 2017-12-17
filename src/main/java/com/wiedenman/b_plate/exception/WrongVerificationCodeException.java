package com.wiedenman.b_plate.exception;

import static java.lang.String.format;

/**
 *    888                      888          888
 *    888                      888          888
 *    888                      888          888
 *    88888b.         88888b.  888  8888b.  888888 .d88b.
 *    888 "88b        888 "88b 888     "88b 888   d8P  Y8b
 *    888  888 888888 888  888 888 .d888888 888   88888888
 *    888 d88P        888 d88P 888 888  888 Y88b. Y8b.
 *    88888P"         88888P"  888 "Y888888  "Y888 "Y8888
 *                    888
 *                    888
 *                    888
 *
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
