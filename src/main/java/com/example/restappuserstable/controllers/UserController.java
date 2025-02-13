package com.example.restappuserstable.controllers;

import com.example.restappuserstable.DTO.request.CreateUserDto;
import com.example.restappuserstable.DTO.response.CreateUserResponse;
import com.example.restappuserstable.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserDto createUserDto){
        return new ResponseEntity<>(userService.createUser(createUserDto), HttpStatus.CREATED);
    }

}
