package com.epam.spring.homework4.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private int id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private float budget;
    private Role role;
}
