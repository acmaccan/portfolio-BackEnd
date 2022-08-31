package com.andreamaccan.backportfolio.repository;

import com.andreamaccan.backportfolio.model.Role;
import com.andreamaccan.backportfolio.enums.RoleEnums;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findRoleByName(RoleEnums name);
}
