package com.example.restappuserstable.DTO.response;

import com.example.restappuserstable.models.RoleEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class CreateUserResponse {
    private UUID id;

    private String email;

    private String name;

    private Set<RoleEntity> roles;

    private String status;
}
