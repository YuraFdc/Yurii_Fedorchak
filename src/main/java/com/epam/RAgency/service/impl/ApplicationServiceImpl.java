package com.epam.RAgency.service.impl;

import com.epam.RAgency.dto.ApplicationDto;
import com.epam.RAgency.exception.ResourceNotFoundException;
import com.epam.RAgency.mapper.MapStructMapper;
import com.epam.RAgency.model.Application;
import com.epam.RAgency.repository.ApplicationRepository;
import com.epam.RAgency.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository repository;
    private final MapStructMapper mapper;

    public ApplicationDto createApplication(ApplicationDto applicationDto){
        log.info("save new application to DB");
        Application application = mapper.mapApplicationDtoToApplication(applicationDto);
        application = repository.save(application);
        return mapper.mapApplicationToApplicationDto(application);
    }

    public List<ApplicationDto> findAllApplications(){
        log.info("get all applications");
        return repository.findAll(Sort.by("userId").and(Sort.by("price").descending()))
                .stream().map(mapper::mapApplicationToApplicationDto)
                .collect(Collectors.toList());
    }

    public ApplicationDto findApplication(Long id){
        log.info("find application by id {}", id);
        Application application = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Oops, can't find such application"));
        return mapper.mapApplicationToApplicationDto(application);
    }

    public ApplicationDto updateApplication(Long id, ApplicationDto applicationDto){
        log.info("update application with id {}", id);
        Application application = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Oops, can't find such application"));

        if (applicationDto.getMasterId() != 0) {
            application.setMasterId(applicationDto.getMasterId());
        }
        if (applicationDto.getDescription() != null) {
            application.setDescription(applicationDto.getDescription());
        }
        if (applicationDto.getPrice() != 0) {
            application.setPrice(applicationDto.getPrice());
        }

        application = repository.save(application);
        return mapper.mapApplicationToApplicationDto(application);
    }

    public void deleteApplication(Long id){
        log.info("delete application with id {}", id);
        repository.deleteById(id);
    }

    public List<ApplicationDto> findApplicationsForUser(String login) {
        log.info("find all applications for user with login {}", login);
        return repository.findAllByLogin(login)
                .stream().map(mapper::mapApplicationToApplicationDto)
                .collect(Collectors.toList());
    }
}
