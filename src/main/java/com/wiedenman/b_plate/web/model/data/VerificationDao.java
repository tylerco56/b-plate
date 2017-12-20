/*
 * Copyright (c) 2017. Landon Wiedenman.  For personal non-commercial use only.  Please contact me for commercial use.
 */

package com.wiedenman.b_plate.web.model.data;

import com.wiedenman.b_plate.web.model.VerificationToken;
import org.springframework.data.repository.CrudRepository;

public interface VerificationDao extends CrudRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);
}
