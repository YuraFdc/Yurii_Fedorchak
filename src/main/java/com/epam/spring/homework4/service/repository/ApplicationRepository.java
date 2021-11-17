package com.epam.spring.homework4.service.repository;

import com.epam.spring.homework4.service.model.Application;

import java.util.List;

public interface ApplicationRepository {

    Application getApplication(int id);

    List<Application> getAllApplications();

    Application addApplication(Application application);

    Application updateApplication(int id, Application application);

    void deleteApplication(int id);
}
