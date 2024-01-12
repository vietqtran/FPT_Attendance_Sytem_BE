package com.fas.services.implementation;

import com.fas.models.entities.Role;
import com.fas.models.enums.RoleType;
import com.fas.models.exceptions.RoleExceptions;
import com.fas.repositories.RoleRepository;
import com.fas.services.RoleSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImplementation implements RoleSevice {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role findRoleByType(RoleType roleType) {
        Optional<Role> role = roleRepository.findByType(roleType);
        if(role.isEmpty()) {
            throw new RoleExceptions("Role not found");
        }
        return role.get();
    }
}
