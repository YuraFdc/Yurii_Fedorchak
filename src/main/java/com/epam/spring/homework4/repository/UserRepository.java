package com.epam.spring.homework4.repository;

import com.epam.spring.homework4.model.User;

import java.util.List;

public interface UserRepository {

    User getUser(String login);

    List<User> getAllUsers();

    User addUser(User user);

    User updateUser(String login, User user);

    void deleteUser(String login);
}