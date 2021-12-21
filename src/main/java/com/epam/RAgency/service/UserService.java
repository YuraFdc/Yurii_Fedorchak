package com.epam.RAgency.service;

import com.epam.RAgency.dto.UserGetDto;
import com.epam.RAgency.dto.UserPostDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    UserGetDto saveUser(UserPostDto userPostDto);
    UserGetDto findUserByLogin(String login);
    List<UserGetDto> findAllUsers(int page, int size);
    void deleteUserByLogin(String login);
    UserGetDto updateUser(String login, UserPostDto userPostDto);
}
