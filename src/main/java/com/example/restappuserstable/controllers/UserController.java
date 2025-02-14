package com.example.restappuserstable.controllers;

import com.example.restappuserstable.DTO.request.UserDtoRequest;
import com.example.restappuserstable.DTO.response.UserDtoResponse;
import com.example.restappuserstable.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  Swagger доступен по ссылке:
 *  👉 http://localhost:8888/swagger-ui/index.html
 */

@Tag(name = "User API", description = "API для работы с пользователями")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    @Operation(summary = "Создание нового пользователя", description = "создает нового пользователя")
    @PostMapping
    public ResponseEntity<UserDtoResponse> createUser(@Valid @RequestBody UserDtoRequest createUserDtoRequest) {
        return new ResponseEntity<>(userService.createUser(createUserDtoRequest), HttpStatus.CREATED);
    }

    @Operation(summary = "Редактирование пользователя", description = "редактирует существующего пользователя")
    @PutMapping("/{id}")
    public ResponseEntity<UserDtoResponse> editUser(@PathVariable String id,
                                                    @Valid @RequestBody UserDtoRequest putUserDtoRequest) {
        return new ResponseEntity<>(userService.editUser(id, putUserDtoRequest), HttpStatus.OK);
    }

    @Operation(summary = "Блокировка пользователя", description = "блокирует пользователя по id")
    @PatchMapping("/block/{id}")
    public ResponseEntity<Void> blockUser(@PathVariable String id) {
        userService.blockUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Разблокировка пользователя", description = "разблокирует пользователя по id")
    @PatchMapping("/unblock/{id}")
    public ResponseEntity<Void> unBlockUser(@PathVariable String id) {
        userService.unBlockUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Удаление пользователя", description = "удаляет пользователя по id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
