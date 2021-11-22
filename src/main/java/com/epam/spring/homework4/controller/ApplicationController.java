package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.controller.dto.ApplicationDto;
import com.epam.spring.homework4.service.ApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Api(tags = "API description for SWAGGER docuemntation")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
public class ApplicationController {

    private final ApplicationService applicationService;

    @ApiOperation("Get all applications")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/application")
    public List<ApplicationDto> getApplication() {
        return applicationService.listApplications();
    }

    @ApiOperation("get application by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/application/{id}")
    public ApplicationDto getApplication(@PathVariable int id) {
        return applicationService.getApplication(id);
    }

    @ApiOperation("create application")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/application")
    public ApplicationDto createApplication(@RequestBody ApplicationDto applicationDto) {
        return applicationService.createApplication(applicationDto);
    }

    @ApiOperation("update application")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/application/{id}")
    public ApplicationDto updateApplication(@PathVariable int id, @RequestBody ApplicationDto applicationDto) {
        return applicationService.updateApplication(id, applicationDto);
    }

    @ApiOperation("delete application")
    @DeleteMapping(value = "/application/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable int id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
}
