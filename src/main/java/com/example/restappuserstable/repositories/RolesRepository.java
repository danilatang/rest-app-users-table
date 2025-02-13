package com.example.restappuserstable.repositories;

import com.example.restappuserstable.models.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface RolesRepository extends JpaRepository<RoleEntity, UUID> {
    Optional<RoleEntity> findByName(String name);

    boolean existsByName(String name);
}
