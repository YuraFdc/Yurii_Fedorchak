package com.epam.RAgency.dto;

import com.epam.RAgency.model.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Data
@Builder
public class UserGetDto {
    @JsonProperty("login")
    private String login;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("budget")
    private double budget;

    @JsonProperty("role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonProperty("applications")
    private List<ApplicationDto> dtoList;
}
