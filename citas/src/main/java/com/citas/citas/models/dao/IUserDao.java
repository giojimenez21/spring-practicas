package com.citas.citas.models.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.citas.citas.models.entity.User;

public interface IUserDao extends CrudRepository<User, Long> {
    public Optional<User> findByUsername(String username);
}
