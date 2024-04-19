package ru.itis.semestrovka.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.semestrovka.dto.NewOrUpdatedUserDto;
import ru.itis.semestrovka.services.UsersService;

import jakarta.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/users")
public class UserController {

    private final UsersService usersService;

    @GetMapping
    public String getAllUsers(int page) {
        usersService.getAllUsers(page);
        return "usersPage";
    }

//    @GetMapping("/{user-id}")
//    public String getUser(@PathVariable("user-id") Long userId) {
//        usersService.getUser(userId);
//        return "userPage";
//    }

    @GetMapping("/profile")
    public String updateUser(Long userId, @Valid NewOrUpdatedUserDto updatedUser) {
        usersService.updateUser(userId, updatedUser);

        return "profile";
    }

//    public String deleteUser(Long userId) {
//        usersService.deleteUser(userId);
//        return ResponseEntity.accepted().build();
//    }
//
//    public String blockUser(Long userId) {
//        usersService.blockUser(userId);
//        return ResponseEntity.accepted().build();
//    }
}
