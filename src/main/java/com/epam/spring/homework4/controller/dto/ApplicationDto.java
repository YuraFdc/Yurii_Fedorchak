package com.epam.spring.homework4.controller.dto;

import com.epam.spring.homework4.model.Status;
import lombok.Builder;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
@Builder
public class ApplicationDto {
    @Id
    private int id;

    private Date creationDate;

    @NotBlank
    private String description;

    @Positive
    private float price;

    @NotNull
    private Status status;

    private String response;
}
