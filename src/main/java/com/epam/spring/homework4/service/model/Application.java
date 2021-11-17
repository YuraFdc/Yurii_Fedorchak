package com.epam.spring.homework4.service.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Application {
    private int id;
    private Date creationDate;
    private int userId;
    private String description;
    private int masterId;
    private float price;
    private Status status;
    private String response;
}
