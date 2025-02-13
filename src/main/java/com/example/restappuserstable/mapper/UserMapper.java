package com.example.restappuserstable.mapper;

import com.example.restappuserstable.DTO.request.CreateUserDto;
import com.example.restappuserstable.DTO.response.CreateUserResponse;
import com.example.restappuserstable.models.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "status", ignore = true)
    UserEntity toUserEntity(CreateUserDto createUserDto);

    CreateUserResponse toCreateUserResponse(UserEntity userEntity);
}
