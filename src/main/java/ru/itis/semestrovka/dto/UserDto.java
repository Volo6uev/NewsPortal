package ru.itis.semestrovka.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.semestrovka.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Пользователь")
public class UserDto {

    @Schema(description = "Идентификатор пользователя", example = "1")
    private Long id;
    @Schema(description = "E-mail пользователя", example = "bob@com")
    private String email;
    @Schema(description = "Имя пользователя", example = "Bob")
    private String username;
    @Schema(description = "Пароль пользователя", example = "123")
    private String hashPassword;

    public static UserDto from(User user){
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .hashPassword(user.getHashPassword())
                .build();
    }

    public static List<UserDto> from(List<User> users) {
        return users.stream().map(UserDto::from).collect(Collectors.toList());
    }
}
