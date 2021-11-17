package com.epam.spring.homework4.service;

import com.epam.spring.homework4.controller.dto.ApplicationDto;

import java.util.List;

public interface ApplicationService {

    ApplicationDto getApplication(int id);

    List<ApplicationDto> listApplications();

    ApplicationDto createApplication(ApplicationDto applicationDto);

    ApplicationDto updateApplication(int id, ApplicationDto applicationDto);

    void deleteApplication(int id);
}
