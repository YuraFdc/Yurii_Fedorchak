package com.epam.spring.homework4.service.repository.impl;

import com.epam.spring.homework4.service.model.Role;
import com.epam.spring.homework4.service.model.User;
import com.epam.spring.homework4.service.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {
    private final List<User> userList = new ArrayList<>();

    @Override
    public User getUser(String login) {
        return userList.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User is not found!"));
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userList);
    }

    @Override
    public User addUser(User user) {

        if(!userList.isEmpty()) {
            userList.stream().filter(u -> u.getLogin().equals(user.getLogin())).forEach(u -> {
                throw new RuntimeException("This login already exist");
            });
            int id = userList
                    .stream().max(Comparator.comparing(User::getId)).get().getId();

            user.setId(id);
        }

        user.setRole(Role.CLIENT);
        user.setBudget(0f);

        userList.add(user);
        return user;
    }

    @Override
    public User updateUser(String login, User user) {
        boolean isDeleted = userList.removeIf(u -> u.getLogin().equals(login));
        if (isDeleted) {
            userList.add(user);
        } else {
            throw new RuntimeException("User is not found!");
        }
        return user;
    }

    @Override
    public void deleteUser(String login) {
        userList.removeIf(user -> user.getLogin().equals(login));
    }
}
