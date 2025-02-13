package com.example.restappuserstable.services;

import com.example.restappuserstable.DTO.request.CreateUserDto;
import com.example.restappuserstable.DTO.response.CreateUserResponse;

public interface UserService {
    CreateUserResponse createUser(CreateUserDto createUserDto);
}
