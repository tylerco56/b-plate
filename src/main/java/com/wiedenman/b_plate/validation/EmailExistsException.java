/*
 * Copyright (c) 2017. Landon Wiedenman.  For personal non-commercial use only.  Please contact me for commercial use.
 */

package com.wiedenman.b_plate.validation;

public class EmailExistsException extends Throwable {

    public EmailExistsException(final String message) {
        super(message);
    }

}
