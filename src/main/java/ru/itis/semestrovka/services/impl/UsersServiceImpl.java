package ru.itis.semestrovka.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.itis.semestrovka.dto.NewOrUpdatedUserDto;
import ru.itis.semestrovka.dto.SignUpForm;
import ru.itis.semestrovka.dto.UserDto;
import ru.itis.semestrovka.dto.UsersPage;
import ru.itis.semestrovka.exceptions.NotFoundException;
import ru.itis.semestrovka.exceptions.WrongPasswordException;
import ru.itis.semestrovka.models.User;
import ru.itis.semestrovka.repositories.UserRepository;
import ru.itis.semestrovka.services.UsersService;

import java.util.Objects;

import static ru.itis.semestrovka.dto.UserDto.from;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;

//    private final PasswordEncoder passwordEncoder;

    @Value("${default.page-size}")
    private int defaultPageSize;

    @Override
    public UsersPage getAllUsers(int page) {
        PageRequest pageRequest = PageRequest.of(page, defaultPageSize);
        Page<User> usersPage = userRepository.findAllByStateOrderById(pageRequest, User.State.ACTIVE);
        return UsersPage.builder()
                .users(from(usersPage.getContent()))
                .totalPagesCount(usersPage.getTotalPages())
                .build();
    }

    @Override
    public UserDto addUser(NewOrUpdatedUserDto newOrUpdatedUserDto) {
        String emailOfNewOrUpdatedUser = newOrUpdatedUserDto.getEmail();
        if(userRepository.findByEmail(emailOfNewOrUpdatedUser).isPresent()){
            throw new DuplicateKeyException("Duplicate key - username field.");
        }
        User user = User.builder()
                .email(newOrUpdatedUserDto.getEmail())
                .username(newOrUpdatedUserDto.getUsername())
//                .hashPassword(passwordEncoder.encode(newOrUpdateUserDto.getPassword()))
                .hashPassword(newOrUpdatedUserDto.getPassword())
                .profileImage("defaultUser.jpg")
                .role(User.Role.USER)
                .state(User.State.ACTIVE)
                .build();
        userRepository.save(user);
        return from(user);
    }

    @Override
    public UserDto getUser(Long userId) {
        return from(getUserOrThrow(userId));
    }


    @Override
    public UserDto updateUser(Long userId, NewOrUpdatedUserDto updatedUser) {
        User userForUpdate = getUserOrThrow(userId);
        userForUpdate.setEmail(updatedUser.getEmail());
        userForUpdate.setUsername(updatedUser.getUsername());
//        userForUpdate.setHashPassword(passwordEncoder.encode(updatedUser.getPassword()));
        userForUpdate.setHashPassword(updatedUser.getPassword());
        userRepository.save(userForUpdate);
        return from(userForUpdate);
    }

    @Override
    public void deleteUser(Long userId) {
        User userForDelete = getUserOrThrow(userId);
        userForDelete.setState(User.State.DELETED);
        userRepository.save(userForDelete);
    }

    @Override
    public void blockUser(Long userId) {
        User userForBlock = getUserOrThrow(userId);
        userForBlock.setState(User.State.BANNED);
        userRepository.save(userForBlock);
    }

    @Override
    public void confirmUser(SignUpForm signUpForm) {
        User user = userRepository.findByEmail(signUpForm.getEmail())
                .orElseThrow((() -> new NotFoundException("Пользователь с email <" + signUpForm.getEmail() + "> не найден")));
        if (!Objects.equals(signUpForm.getPassword(), user.getHashPassword())) {
            throw new WrongPasswordException("Неверный пароль");
        }

    }

    private User getUserOrThrow(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow((() -> new NotFoundException("Пользователь с идентификатором <" + userId + "> не найден")));
    }
}
