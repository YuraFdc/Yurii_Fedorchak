package com.epam.RAgency.dto;

import com.epam.RAgency.model.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class UserPostDto {

    @NotBlank
    @JsonProperty("login")
    private String login;

    @NotBlank
    @JsonProperty("password")
    private String password;

    @NotBlank
    @JsonProperty("firstName")
    private String firstName;

    @NotBlank
    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("budget")
    private double budget;

    @Enumerated(EnumType.STRING)
    @JsonProperty("role")
    private Role role;
}