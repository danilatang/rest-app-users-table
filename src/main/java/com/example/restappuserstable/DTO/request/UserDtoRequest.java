package com.example.restappuserstable.DTO.request;

import com.example.restappuserstable.constants.ValidationConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "запрос DTO пользователя")
public class UserDtoRequest {
    @Schema(description = "ФИО пользователя", example = "Петр Иванов")
    private String name;

    @Schema(description = "Email пользователя", example = "ivan@gmail.com")
    @NotEmpty(message = ValidationConstants.EMAIL_NOT_EMPTY)
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = ValidationConstants.EMAIL_NOT_VALID)
    private String email;

    @Schema(description = "Список ролей пользователя", example = "[admin, user]")
    private Set<String> roles;
}
