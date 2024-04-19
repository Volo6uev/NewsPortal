package ru.itis.semestrovka.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Пользователь для аутентификации")
public class SignUpForm {

    @Schema(description = "E-mail пользователя", example = "bob@com")
    @NotBlank(message = "{signUp.email.blank}")
    @Email(message = "{signUp.email.invalid}")
    private String email;

    @Schema(description = "Пароль пользователя", example = "123")
    @NotBlank(message = "{signUp.password.blank}")
    @Size(min = 3,max = 20,message = "{signUp.password.size}")
    private String password;
}
