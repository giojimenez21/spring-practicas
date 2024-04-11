package com.gio.app.crud.services;

import java.util.List;

import com.gio.app.crud.entities.User;

public interface UserService {
    List<User> findAll();
    User save(User user);
    boolean existsByUsername(String username);
}
