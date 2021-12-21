package com.epam.RAgency.service.impl;

import com.epam.RAgency.dto.UserGetDto;
import com.epam.RAgency.dto.UserPostDto;
import com.epam.RAgency.exception.ResourceNotFoundException;
import com.epam.RAgency.mapper.MapStructMapper;
import com.epam.RAgency.model.User;
import com.epam.RAgency.repository.UserRepository;
import com.epam.RAgency.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MapStructMapper mapStructMapper;

    public UserGetDto findUserByLogin(String login) {
        log.info("get User by login {}", login);
        User user = userRepository.getUserByLogin(login);
        if(user == null){
            throw new ResourceNotFoundException("Oops, cant find user with login "  + login);
        }
        return mapStructMapper.mapUserToUserGetDto(user);
    }

    public List<UserGetDto> findAllUsers(int page, int size) {
        log.info("get all users");
        Pageable pageable = PageRequest.of(page, size);
        Page<User> userPage = userRepository.findAll(pageable);

        return userPage
                .stream()
                .map(mapStructMapper::mapUserToUserGetDto)
                .collect(Collectors.toList());
    }

    public UserGetDto saveUser(UserPostDto userPostDto) {
        log.info("save new user to DB");
        User user = mapStructMapper.mapUserPostDtoToUser(userPostDto);
        user = userRepository.save(user);
        return mapStructMapper.mapUserToUserGetDto(user);
    }

    public void deleteUserByLogin(String login) {
        log.info("delete User with login {}", login);
        userRepository.deleteUserByLoginEquals(login);
    }

    public UserGetDto updateUser(String login, UserPostDto userPostDto) {
        log.info("update User with login {}", login);
        User user = userRepository.getUserByLogin(login);
        if(user == null){
            throw new ResourceNotFoundException("Oops, cant find user with login " + login);
        }

        if (userPostDto.getLogin() != null) {
            user.setLogin(userPostDto.getLogin());
        }
        if (userPostDto.getPassword() != null) {
            user.setPassword(userPostDto.getPassword());
        }
        if (userPostDto.getFirstName() != null) {
            user.setFirstName(userPostDto.getFirstName());
        }
        if (userPostDto.getLastName() != null) {
            user.setLastName(userPostDto.getLastName());
        }
        if (userPostDto.getBudget() != 0) {
            user.setBudget(userPostDto.getBudget());
        }
        if(userPostDto.getRole() != null) {
            user.setRole(userPostDto.getRole());
        }

        userRepository.save(user);
        return mapStructMapper.mapUserToUserGetDto(user);
    }


}
