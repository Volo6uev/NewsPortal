package ru.itis.semestrovka.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.semestrovka.validation.constraints.PasswordsMatch;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Пользователь")
@PasswordsMatch(fields = {"password","passwordRepeat"},message = "{newUser.passwords.match}")
public class NewOrUpdatedUserDto {

    @Schema(description = "E-mail пользователя", example = "bob@com")
    @NotBlank(message = "{newUser.email.blank}")
    @Email(message = "{newUser.email.invalid}")
    private String email;

    @Schema(description = "Имя пользователя", example = "Bob")
    @NotBlank(message = "{newUser.username.blank}")
    @Size(min = 3,max = 20,message = "{newUser.username.size}")
    private String username;

    @Schema(description = "Пароль пользователя", example = "123")
    @NotBlank(message = "{newUser.password.blank}")
    @Size(min = 3,max = 20,message = "{newUser.password.size}")
    private String password;

    @Schema(description = "Повторный пароль пользователя", example = "123")
    @NotBlank(message = "{newUser.password.repeat.blank}")
    @Size(min = 3,max = 20,message = "{newUser.password.repeat.size}")
    private String passwordRepeat;
}
