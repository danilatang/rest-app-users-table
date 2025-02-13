package com.example.restappuserstable.services.impl;

import com.example.restappuserstable.DTO.request.CreateUserDto;
import com.example.restappuserstable.DTO.response.CreateUserResponse;
import com.example.restappuserstable.constants.ErrorCodes;
import com.example.restappuserstable.constants.UserStatus;
import com.example.restappuserstable.handling.CustomException;
import com.example.restappuserstable.mapper.UserMapper;
import com.example.restappuserstable.models.UserEntity;
import com.example.restappuserstable.repositories.UserRepository;
import com.example.restappuserstable.services.RolesService;
import com.example.restappuserstable.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final RolesService rolesService;

    private final UserMapper userMapper;

    @Transactional
    public CreateUserResponse createUser(CreateUserDto createUserDto) {
        if (userRepository.existsByEmail(createUserDto.getEmail())) {
            throw new CustomException(ErrorCodes.USER_WITH_EMAIL_ALREADY_EXIST);
        }
        UserEntity user = userMapper.toUserEntity(createUserDto);
        user.setStatus(UserStatus.UNBLOCKED.name());
        user.setRoles(rolesService.createRoles(createUserDto.getRoles()));
        userRepository.save(user);
        CreateUserResponse createUserResponse = userMapper.toCreateUserResponse(user);
        createUserResponse.setRoles(user.getRoles());
        return createUserResponse;
    }
}
