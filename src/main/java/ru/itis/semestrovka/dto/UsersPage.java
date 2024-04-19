package ru.itis.semestrovka.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Страница с пользователями и общее кол-во пользователей")
public class UsersPage {
    @Schema(description = "Список пользователей")
    private List<UserDto> users;
    @Schema(description = "Количество пользователей", example = "3")
    private Integer totalPagesCount;
}
