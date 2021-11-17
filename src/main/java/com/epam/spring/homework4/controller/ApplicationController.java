package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.controller.dto.ApplicationDto;
import com.epam.spring.homework4.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/application")
    public List<ApplicationDto> getApplication() {
        return applicationService.listApplications();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/application/{id}")
    public ApplicationDto getApplication(@PathVariable int id) {
        return applicationService.getApplication(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/application")
    public ApplicationDto createApplication(@RequestBody ApplicationDto applicationDto) {
        return applicationService.createApplication(applicationDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/application/{id}")
    public ApplicationDto updateApplication(@PathVariable int id, @RequestBody ApplicationDto applicationDto) {
        return applicationService.updateApplication(id, applicationDto);
    }

    @DeleteMapping(value = "/application/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable int id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
}
