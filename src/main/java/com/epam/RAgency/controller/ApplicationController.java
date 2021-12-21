package com.epam.RAgency.controller;

import com.epam.RAgency.dto.ApplicationDto;
import com.epam.RAgency.service.impl.ApplicationServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationServiceImpl service;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public ApplicationDto createApp(@Valid @RequestBody ApplicationDto applicationDto){
        return service.createApplication(applicationDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<ApplicationDto> getAllApps(){
        return service.findAllApplications();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public ApplicationDto getApp(@PathVariable Long id){
        return service.findApplication(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}")
    public ApplicationDto updateApp(@PathVariable Long id, @RequestBody ApplicationDto applicationDto){
        return service.updateApplication(id, applicationDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteApp(@PathVariable Long id){
        service.deleteApplication(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user/{login}")
    public List<ApplicationDto> getAllApplicationsForUser(@PathVariable String login) {
        return service.findApplicationsForUser(login);
    }
}