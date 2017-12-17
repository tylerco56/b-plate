package com.wiedenman.b_plate.exception;

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

public class DomainException extends RuntimeException {

    public DomainException(final String message) {
        super(message);
    }

    public DomainException(final String message, final Exception e) {
        super(message, e);
    }

}