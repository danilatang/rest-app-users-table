package com.example.restappuserstable.services.impl;

import com.example.restappuserstable.models.RoleEntity;
import com.example.restappuserstable.repositories.RolesRepository;
import com.example.restappuserstable.services.RolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RolesServiceImpl implements RolesService {
    private final RolesRepository rolesRepository;

    @Transactional
    public Set<RoleEntity> createRoles(Set<String> roles) {
        return roles.stream().map(String::toLowerCase).map(roleElement -> {
            if (!rolesRepository.existsByName(roleElement)) {
                RoleEntity role = new RoleEntity();
                role.setName(roleElement);
                return rolesRepository.save(role);
            } else {
                return rolesRepository.findByName(roleElement).orElseThrow();
            }
        }).collect(Collectors.toSet());
    }
}
