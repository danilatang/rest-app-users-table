package com.example.restappuserstable.DTO.response;

import com.example.restappuserstable.models.RoleEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Schema(description = "ответ DTO пользователя")
public class UserDtoResponse {
    @Schema(description = "id пользователя", example = "1cc4b715-f4a9-4984-b3ab-379249d22349")
    private UUID id;

    @Schema(description = "Email пользователя", example = "ivan@gmail.com")
    private String email;

    @Schema(description = "ФИО пользователя", example = "Петр Иванов")
    private String name;

    @Schema(description = "Список ролей пользователя", example = "[admin, user]")
    private Set<RoleEntity> roles;

    @Schema(description = "Статус пользователя", example = "UNBLOCKED")
    private String status;
}
