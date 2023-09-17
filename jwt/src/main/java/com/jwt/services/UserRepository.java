package com.jwt.services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.models.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{ 
    Optional<User> findByUsername(String username);
}
