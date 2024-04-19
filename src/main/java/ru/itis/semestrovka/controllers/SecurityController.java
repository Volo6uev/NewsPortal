package ru.itis.semestrovka.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itis.semestrovka.dto.NewOrUpdatedUserDto;
import ru.itis.semestrovka.dto.SignUpForm;
import ru.itis.semestrovka.exceptions.NotFoundException;
import ru.itis.semestrovka.exceptions.WrongPasswordException;
import ru.itis.semestrovka.services.UsersService;

import jakarta.validation.Valid;

@RequiredArgsConstructor
@Controller
public class SecurityController {

    private final UsersService usersService;

    @GetMapping("/registration")
    public String getRegistrationPage(ModelMap model) {
        model.addAttribute("newOrUpdatedUserDto" , new NewOrUpdatedUserDto());
        return "registrationPage";
    }

    @PostMapping("/registration")
    public String addUser(@Valid @ModelAttribute("newOrUpdatedUserDto") NewOrUpdatedUserDto newOrUpdatedUserDto,
                          BindingResult result,
                          ModelMap model) {
        if (!result.hasErrors()) {
            try{
                usersService.addUser(newOrUpdatedUserDto);
                return "profile";
            } catch (DuplicateKeyException e) {
                result.rejectValue("email", "entry.duplicate", "There is account with such email already.");
            }
        }
        return "registrationPage";
    }

    @GetMapping("/authentication")
    public String getAuthenticationPage(ModelMap model) {
        model.addAttribute("signUpForm" , new SignUpForm());
        return "authenticationPage";
    }

    @PostMapping("/authentication")
    public String authenticateUser(@Valid @ModelAttribute("signUpForm") SignUpForm signUpForm,
                          BindingResult result,
                          ModelMap model) {
        if (!result.hasErrors()) {
            try{
                usersService.confirmUser(signUpForm);
                return "profile";
            } catch (NotFoundException e) {
                result.rejectValue("email", "entry.duplicate", "Email do not exist");
            } catch (WrongPasswordException e) {
                result.rejectValue("password","field.wrong", "Wrong email");
            }
        }
        return "authenticationPage";
    }
}
