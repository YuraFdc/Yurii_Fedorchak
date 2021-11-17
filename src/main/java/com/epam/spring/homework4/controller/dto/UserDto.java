package com.epam.spring.homework4.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String login;
    private String firstName;
    private String lastName;
}