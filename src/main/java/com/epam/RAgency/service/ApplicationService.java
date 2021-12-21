package com.epam.RAgency.service;

import com.epam.RAgency.dto.ApplicationDto;

import java.util.List;

public interface ApplicationService {
    ApplicationDto createApplication(ApplicationDto applicationDto);
    List<ApplicationDto> findAllApplications();
    ApplicationDto findApplication(Long id);
    ApplicationDto updateApplication(Long id, ApplicationDto applicationDto);
    void deleteApplication(Long id);
}
