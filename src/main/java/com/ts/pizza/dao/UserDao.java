package com.ts.pizza.dao;

import com.ts.pizza.web.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;

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
 * @author Landon Wiedenman
 * github.com/landongw/b-plate
 * Usage: or personal non-commercial use only.  Please contact me for commercial uses.
 *
 * Copyright (c) 2017 Landon Wiedenman
 */

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Long> {

    User findByEmail(String email);
    Optional<User> findUserByEmail(String email);
    User findByUsername(String username);
    Optional<User> findByResetToken(String resetToken);
    User findOne(long id);
//    Optional<User> save(User user);

}
