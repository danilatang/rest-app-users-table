package com.example.restappuserstable.mapper;

import com.example.restappuserstable.DTO.request.UserDtoRequest;
import com.example.restappuserstable.DTO.response.UserDtoResponse;
import com.example.restappuserstable.models.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "status", ignore = true)
    UserEntity toUserEntity(UserDtoRequest createUserDtoRequest);

    UserDtoResponse toCreateUserResponse(UserEntity userEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "email", ignore = true)
    UserEntity toUserEntityFromPutUserDTO(@MappingTarget UserEntity userEntity, UserDtoRequest putUserDTORequest);

    UserDtoResponse toPutUserResponse(UserEntity userEntity);
}
