package com.example.restappuserstable.services.impl;

import com.example.restappuserstable.DTO.request.UserDtoRequest;
import com.example.restappuserstable.DTO.response.UserDtoResponse;
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
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final RolesService rolesService;

    private final UserMapper userMapper;

    @Transactional
    public UserDtoResponse createUser(UserDtoRequest createUserDtoRequest) {
        if (userRepository.existsByEmail(createUserDtoRequest.getEmail())) {
            throw new CustomException(ErrorCodes.USER_WITH_EMAIL_ALREADY_EXIST);
        }

        UserEntity user = userMapper.toUserEntity(createUserDtoRequest);
        user.setStatus(UserStatus.UNBLOCKED.name());
        user.setRoles(rolesService.createRoles(createUserDtoRequest.getRoles()));
        userRepository.save(user);

        UserDtoResponse createUserResponse = userMapper.toCreateUserResponse(user);
        createUserResponse.setRoles(user.getRoles());
        return createUserResponse;
    }

    @Transactional
    public UserDtoResponse editUser(String id, UserDtoRequest putUserDtoRequest) {
        UserEntity existingUser = userRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new CustomException(ErrorCodes.USER_NOT_FOUND));

        if (userRepository.existsByEmail(putUserDtoRequest.getEmail()) && !existingUser.getEmail().equals(putUserDtoRequest.getEmail())) {
            throw new CustomException(ErrorCodes.USER_WITH_EMAIL_ALREADY_EXIST);
        }

        UserEntity user = userMapper.toUserEntityFromPutUserDTO(userRepository.findById(UUID.fromString(id)).orElseThrow(() -> new CustomException(ErrorCodes.USER_NOT_FOUND)), putUserDtoRequest);
        user.setEmail(putUserDtoRequest.getEmail());
        user.setRoles(rolesService.createRoles(putUserDtoRequest.getRoles()));

        UserDtoResponse putUserResponse = userMapper.toPutUserResponse(user);
        putUserResponse.setRoles(user.getRoles());

        return userMapper.toPutUserResponse(user);
    }

    public void blockUser(String id) {
        UserEntity existingUser = userRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new CustomException(ErrorCodes.USER_NOT_FOUND));
        existingUser.setStatus(UserStatus.BLOCKED.name());
        userRepository.save(existingUser);
    }

    public void unBlockUser(String id) {
        UserEntity existingUser = userRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new CustomException(ErrorCodes.USER_NOT_FOUND));
        existingUser.setStatus(UserStatus.UNBLOCKED.name());
        userRepository.save(existingUser);
    }

    public void deleteUser(String id) {
        UserEntity existingUser = userRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new CustomException(ErrorCodes.USER_NOT_FOUND));
        userRepository.delete(existingUser);
    }
}
