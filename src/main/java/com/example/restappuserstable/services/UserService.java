package com.example.restappuserstable.services;

import com.example.restappuserstable.DTO.request.UserDtoRequest;
import com.example.restappuserstable.DTO.response.UserDtoResponse;

public interface UserService {
    UserDtoResponse createUser(UserDtoRequest createUserDtoRequest);

    UserDtoResponse editUser(String id, UserDtoRequest putUserDtoRequest);

    void blockUser(String id);

    void unBlockUser(String id);

    void deleteUser(String id);
}
