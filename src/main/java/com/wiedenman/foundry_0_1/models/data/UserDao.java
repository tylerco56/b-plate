package com.wiedenman.foundry_0_1.models.data;

import com.wiedenman.foundry_0_1.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);
    User findByUsername(String username);


}
