package com.epam.RAgency.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Positive;


@Data
@Builder
public class ApplicationDto {
    @JsonProperty("applicationId")
    private Long applicationId;

    @NonNull
    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("masterId")
    private Long masterId;

    @JsonProperty("description")
    private String description;

    @Positive
    @JsonProperty("price")
    private double price;
}
