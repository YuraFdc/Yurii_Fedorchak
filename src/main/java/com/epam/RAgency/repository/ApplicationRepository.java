package com.epam.RAgency.repository;

import com.epam.RAgency.model.Application;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    @Query("SELECT u.applications FROM User u WHERE u.login = ?1")
    List<Application> findAllByLogin(String login);

    @Override
    List<Application> findAll(Sort sort);
}
