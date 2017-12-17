package com.wiedenman.b_plate.model.data;

import com.wiedenman.b_plate.model.Role;
import com.wiedenman.b_plate.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface RoleDao extends CrudRepository<User, Integer> {
    Optional<Role> findByRole(String role);
}

