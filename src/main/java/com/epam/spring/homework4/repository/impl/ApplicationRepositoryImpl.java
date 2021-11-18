package com.epam.spring.homework4.repository.impl;

import com.epam.spring.homework4.model.Application;
import com.epam.spring.homework4.model.Status;
import com.epam.spring.homework4.repository.ApplicationRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Component
public class ApplicationRepositoryImpl implements ApplicationRepository {
    private final List<Application> applicationList = new ArrayList<>();

    @Override
    public Application getApplication(int id) {
        return applicationList.stream()
                .filter(u -> u.getId() == id).findFirst()
                .orElseThrow(() -> new RuntimeException("Application is not fount"));
    }

    @Override
    public List<Application> getAllApplications() {
        return new ArrayList<>(applicationList);
    }

    @Override
    public Application addApplication(Application application) {
        int id;
        if (!applicationList.isEmpty()) {
            id = applicationList.stream()
                    .max(Comparator.comparing(Application::getId)).get().getId();
        } else id = 0;

        application.setId(id);
        application.setCreationDate(new Date());
        application.setStatus(Status.NEW);

        applicationList.add(application);
        return application;
    }

    @Override
    public Application updateApplication(int id, Application application) {
        boolean isDeleted = applicationList.removeIf(a -> a.getId() == id);
        if(isDeleted) {
            applicationList.add(application);
        } else {
            throw new RuntimeException("Application is not found!");
        }
        return application;
    }

    @Override
    public void deleteApplication(int id) {
        applicationList.removeIf(a -> a.getId() == id);
    }
}