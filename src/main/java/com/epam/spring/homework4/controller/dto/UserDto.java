package com.epam.spring.homework4.controller.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class UserDto {
    @NotBlank
    private String login;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;
}