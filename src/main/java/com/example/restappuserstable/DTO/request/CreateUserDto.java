package com.example.restappuserstable.DTO.request;

import com.example.restappuserstable.constants.ValidationConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {
    private String name;

    @Email(message = ValidationConstants.EMAIL_NOT_VALID)
    @NotEmpty(message = ValidationConstants.EMAIL_NOT_EMPTY)
    private String email;

    private Set<String> roles;
}
