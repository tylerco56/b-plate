package com.wiedenman.foundry_0_1.model.data;

import com.wiedenman.foundry_0_1.model.Role;
import com.wiedenman.foundry_0_1.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface RoleDao extends CrudRepository<User, Integer> {
    Optional<Role> findByRole(String role);
}

