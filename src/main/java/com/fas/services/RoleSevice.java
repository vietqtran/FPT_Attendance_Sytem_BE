package com.fas.services;

import com.fas.models.entities.Role;
import com.fas.models.enums.RoleType;

public interface RoleSevice {
    public Role findRoleByType(RoleType roleType);
}
