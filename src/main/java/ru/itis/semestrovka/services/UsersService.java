package ru.itis.semestrovka.services;


import ru.itis.semestrovka.dto.NewOrUpdatedUserDto;
import ru.itis.semestrovka.dto.SignUpForm;
import ru.itis.semestrovka.dto.UserDto;
import ru.itis.semestrovka.dto.UsersPage;

public interface UsersService {

    UsersPage getAllUsers(int page);

    UserDto addUser(NewOrUpdatedUserDto newOrUpdatedUserDto);

    UserDto getUser(Long userId);

    UserDto updateUser(Long userId, NewOrUpdatedUserDto updatedUser);

    void deleteUser(Long userId);

    void blockUser(Long userId);

    void confirmUser(SignUpForm signUpForm);
}
