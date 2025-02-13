package com.example.restappuserstable.services;

import com.example.restappuserstable.models.RoleEntity;
import java.util.Set;

public interface RolesService {
    Set<RoleEntity> createRoles(Set<String> roles);
}
