package com.epam.RAgency.repository;

import com.epam.RAgency.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findAll(Pageable pageable);

    User getUserByLogin(String login);

    void deleteUserByLoginEquals(String login);

    //Page<User> findByFirstName(String firstName, Pegable pegable);
}
