package com.wiedenman.b_plate.model.data;

import com.wiedenman.b_plate.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findUserByEmail(String email);
    User findByUsername(String username);
    Optional<User> findByResetToken(String resetToken);
}
