package ru.itis.semestrovka.controllers.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.semestrovka.controllers.api.UserApi;
import ru.itis.semestrovka.dto.NewOrUpdatedUserDto;
import ru.itis.semestrovka.dto.UserDto;
import ru.itis.semestrovka.dto.UsersPage;
import ru.itis.semestrovka.services.UsersService;

@RequiredArgsConstructor
@RestController
public class UserRestController implements UserApi {

    private final UsersService usersService;

    @Override
    public ResponseEntity<UsersPage> getAllUsers(int page) {
        return ResponseEntity.ok(usersService.getAllUsers(page));
    }

    @Override
    public ResponseEntity<UserDto> addUser(@Valid NewOrUpdatedUserDto newOrUpdatedUserDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.addUser(newOrUpdatedUserDto));
    }

    @Override
    public ResponseEntity<UserDto> getUser(Long userId) {
        return ResponseEntity.ok(usersService.getUser(userId));
    }

    @Override
    public ResponseEntity<UserDto> updateUser(Long userId, @Valid NewOrUpdatedUserDto updatedUser) {
        return ResponseEntity.accepted().body(usersService.updateUser(userId, updatedUser));
    }

    @Override
    public ResponseEntity<?> deleteUser(Long userId) {
        usersService.deleteUser(userId);
        return ResponseEntity.accepted().build();
    }

//    @Override
//    public ResponseEntity<UserDto> activateUser(Long userId) {
//        return ResponseEntity.accepted().body(usersService.activateUser(userId));
//    }
}
