package com.epam.spring.homework4.controller.dto;

import com.epam.spring.homework4.service.model.Status;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ApplicationDto {
    private Date creationDate;
    private String description;
    private float price;
    private Status status;
    private String response;
}
