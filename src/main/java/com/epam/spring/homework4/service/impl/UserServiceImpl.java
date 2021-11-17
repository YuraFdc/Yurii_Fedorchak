package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.controller.dto.UserDto;
import com.epam.spring.homework4.service.UserService;
import com.epam.spring.homework4.service.model.User;
import com.epam.spring.homework4.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String login) {
        log.info("getUser by login {}", login);
        User user = userRepository.getUser(login);
        return mapUserToUserDto(user);
    }

    @Override
    public List<UserDto> listUsers() {
        log.info("get all users");
        return userRepository.getAllUsers()
                .stream()
                .map(this::mapUserToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("createUser with login {}", userDto.getLogin());
        User user = mapUserDtoToUser(userDto);
        user = userRepository.addUser(user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(String login, UserDto userDto) {
        log.info("updateUser with login {}", login);
        User user = mapUserDtoToUser(userDto);
        user = userRepository.updateUser(login, user);
        return mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(String login) {
        log.info("deleteUser by login {}", login);
        userRepository.deleteUser(login);
    }

    private UserDto mapUserToUserDto(final User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .build();
    }

    private User mapUserDtoToUser(final UserDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .login(userDto.getLogin())
                .build();
    }
}
