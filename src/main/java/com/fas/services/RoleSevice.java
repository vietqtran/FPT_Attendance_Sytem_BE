package com.fas.services;

import com.fas.models.entities.Role;
import com.fas.models.enums.RoleType;

import java.util.List;

public interface RoleSevice {
    public Role findRoleByType(RoleType roleType);

    public List<Role> findAllRoles();
}
