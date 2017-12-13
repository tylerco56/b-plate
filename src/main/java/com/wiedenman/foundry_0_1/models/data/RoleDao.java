package com.wiedenman.foundry_0_1.models.data;

import com.wiedenman.foundry_0_1.models.Role;
import com.wiedenman.foundry_0_1.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface RoleDao extends CrudRepository<User, Integer> {
    Optional<Role> findByRole(String role);
}

