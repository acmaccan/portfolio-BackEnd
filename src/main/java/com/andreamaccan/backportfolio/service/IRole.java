package com.andreamaccan.backportfolio.service;

import com.andreamaccan.backportfolio.enums.RoleEnums;
import com.andreamaccan.backportfolio.model.Role;
import java.util.Optional;

public interface IRole {
    public Optional<Role> getRoleByName(RoleEnums name);
    public void createRole(Role role);
}
