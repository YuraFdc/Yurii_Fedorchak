package com.epam.RAgency.controller;

import com.epam.RAgency.dto.UserGetDto;
import com.epam.RAgency.dto.UserPostDto;
import com.epam.RAgency.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public UserGetDto saveUser(@Valid @RequestBody UserPostDto userPostDto) {
        return userServiceImpl.saveUser(userPostDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserGetDto> findAllUsers(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "3") int size) {
        return userServiceImpl.findAllUsers(page, size);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{login}")
    public UserGetDto findUserByLogin(@PathVariable String login){
        return userServiceImpl.findUserByLogin(login);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{login}")
    public UserGetDto updateUser(@PathVariable String login, @RequestBody UserPostDto userPostDto) {
        return userServiceImpl.updateUser(login, userPostDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{login}")
    public void deleteUser(@PathVariable String login) {
       userServiceImpl.deleteUserByLogin(login);
    }

}
