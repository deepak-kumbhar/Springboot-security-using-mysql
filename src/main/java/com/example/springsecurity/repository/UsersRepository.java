package com.example.springsecurity.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springsecurity.model.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {
    Optional<User> findByFirstName(String firstname);
}
