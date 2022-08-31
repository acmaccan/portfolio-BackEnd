
package com.andreamaccan.backportfolio.service;

import com.andreamaccan.backportfolio.model.Role;
import com.andreamaccan.backportfolio.enums.RoleEnums;
import com.andreamaccan.backportfolio.repository.RoleRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService implements IRole {
    
    @Autowired
    public RoleRepository roleRepository;

    public Optional<Role> getRoleByName(RoleEnums name) {
        return roleRepository.findRoleByName(name);
    }
    
    public void createRole(Role role) {
        roleRepository.save(role);
    }
}
