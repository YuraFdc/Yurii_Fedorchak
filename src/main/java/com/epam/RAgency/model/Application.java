package com.epam.RAgency.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long applicationId;

   @Column(name = "user_id")
    private Long userId;

    @Column(name = "master_id")
    private Long masterId;

    @Column(name = "application_description")
    private String description;

    @Column(name = "application_price")
    private double price;
}
