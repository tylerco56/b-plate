/*
 * Copyright (c) 2017. Landon Wiedenman.  For personal non-commercial use only.  Please contact me for commercial use.
 */

package com.wiedenman.b_plate.model.data;

import com.wiedenman.b_plate.model.PasswordResetToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PasswordResetTokenDao extends CrudRepository<PasswordResetToken, Long> {

    PasswordResetToken findByToken(String token);

}
