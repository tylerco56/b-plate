package com.wiedenman.b_plate.model.data;

import com.wiedenman.b_plate.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;

/**
 *   _                       _         _
 *  | |                     | |       | |
 *  | |__    ______   _ __  | |  __ _ | |_  ___
 *  | '_ \| |______| | '_ \ | | / _` || __|/ _ \
 *  | |_) |          | |_) || || (_| || |_|  __/
 *  |_.__/           | .__/ |_| \__,_| \__|\___|
 *      	         | |
 *  			     |_|
 *
 * @author by Landon Wiedenman - github.com/landongw/b-plate
 *
 * License: for personal non-commercial use only.  Please contact me for commercial uses.
 *
 * */

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findUserByEmail(String email);
    User findByUsername(String username);
    Optional<User> findByResetToken(String resetToken);
}
