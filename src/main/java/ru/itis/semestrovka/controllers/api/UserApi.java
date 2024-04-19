package ru.itis.semestrovka.controllers.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.semestrovka.dto.ExceptionDto;
import ru.itis.semestrovka.dto.NewOrUpdatedUserDto;
import ru.itis.semestrovka.dto.UserDto;
import ru.itis.semestrovka.dto.UsersPage;

@Tags(value = {
        @Tag(name = "Users")
})
@RequestMapping("/rest/users")
public interface UserApi {

    @Operation(summary = "Получение списка пользователей")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Стриница с пользователями",
            content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UsersPage.class))
            })
    })
    @GetMapping
    ResponseEntity<UsersPage> getAllUsers(@Parameter(description = "Номер страницы") @RequestParam("page") int page);



    @Operation(summary = "Добавление пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Добавленный пользователь",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    })
    })
    @PostMapping
    ResponseEntity<UserDto> addUser(@RequestBody NewOrUpdatedUserDto newOrUpdatedUserDto);



    @Operation(summary = "Получение пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Полученынй пользователь",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    }),
            @ApiResponse(responseCode = "404",description = "Сведения об ошибке",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))
                    })
    })
    @GetMapping("/{users-id}")
    ResponseEntity<UserDto> getUser(@Parameter(description = "Идентификатор пользователя",example = "1")
                                    @PathVariable("users-id") Long userId);


    @Operation(summary = "Обновление пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202",description = "Обновленный пользователь",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    }),
            @ApiResponse(responseCode = "404",description = "Сведения об ошибке",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))
                    })
    })
    @PutMapping("/{users-id}")
    ResponseEntity<UserDto> updateUser(@Parameter(description = "Идентификатор пользователя",example = "1")
                                       @PathVariable("users-id") Long userId,
                                       @RequestBody NewOrUpdatedUserDto updatedUser);


    @Operation(summary = "Удаление пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202",description = "Пользователь удален"),
            @ApiResponse(responseCode = "404",description = "Сведения об ошибке",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))
                    })
    })
    @DeleteMapping("/{users-id}")
    ResponseEntity<?> deleteUser(@Parameter(description = "Идентификатор пользователя",example = "1")
                                       @PathVariable("users-id") Long userId);


//    @Operation(summary = "Активация пользователя")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "202",description = "Активированный пользователь",
//                    content = {
//                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
//                    }),
//            @ApiResponse(responseCode = "404",description = "Сведения об ошибке",
//                    content = {
//                            @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))
//                    })
//    })
//    @PutMapping("/{users-id}/activate")
//    ResponseEntity<UserDto> activateUser(@Parameter(description = "Идентификатор пользователя",example = "1")
//                                       @PathVariable("users-id") Long userId);
}
