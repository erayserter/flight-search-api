package com.erayserter.flightsearchapi.authentication.repository;

import java.util.Optional;

import com.erayserter.flightsearchapi.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}