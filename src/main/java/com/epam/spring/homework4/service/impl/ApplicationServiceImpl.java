package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.controller.dto.ApplicationDto;
import com.epam.spring.homework4.service.ApplicationService;
import com.epam.spring.homework4.model.Application;

import com.epam.spring.homework4.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;

    @Override
    public ApplicationDto getApplication(int id) {
        log.info("get Application by id {}", id);
        Application application = applicationRepository.getApplication(id);
        return mapApplicationToApplicationDto(application);
    }

    @Override
    public List<ApplicationDto> listApplications() {
        log.info("get all applications");
        return applicationRepository.getAllApplications()
                .stream().map(this::mapApplicationToApplicationDto)
                .collect(Collectors.toList());
    }

    @Override
    public ApplicationDto createApplication(ApplicationDto applicationDto) {
        log.info("create application");
        Application application = mapApplicationDTOToApplication(applicationDto);
        application = applicationRepository.addApplication(application);
        return mapApplicationToApplicationDto(application);
    }

    @Override
    public ApplicationDto updateApplication(int id, ApplicationDto applicationDto) {
        log.info("update application with id {}", id);
        Application application = mapApplicationDTOToApplication(applicationDto);
        application = applicationRepository.updateApplication(id, application);
        return mapApplicationToApplicationDto(application);
    }

    @Override
    public void deleteApplication(int id) {
        log.info("delete application by id {}", id);
        applicationRepository.deleteApplication(id);
    }

    private ApplicationDto mapApplicationToApplicationDto(Application application) {
        return ApplicationDto.builder()
                .creationDate(application.getCreationDate())
                .description(application.getDescription())
                .price(application.getPrice())
                .status(application.getStatus())
                .response(application.getResponse())
                .build();
    }

    private Application mapApplicationDTOToApplication(ApplicationDto applicationDto) {
        return Application.builder()
                .creationDate(applicationDto.getCreationDate())
                .description(applicationDto.getDescription())
                .price(applicationDto.getPrice())
                .status(applicationDto.getStatus())
                .response(applicationDto.getResponse())
                .build();
    }
}
