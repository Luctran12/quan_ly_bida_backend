package org.example.quan_ly_bida_backend.service;

import org.example.quan_ly_bida_backend.model.EnumRole;
import org.example.quan_ly_bida_backend.model.Role;
import org.example.quan_ly_bida_backend.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepo roleRepo;

    public Role findByRoleName(EnumRole roleName) {
        return roleRepo.findByRoleName(roleName);
    }
}
