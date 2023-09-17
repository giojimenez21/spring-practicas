package com.citas.citas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citas.citas.models.entity.User;
import com.citas.citas.models.service.IUserDbService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.annotation.security.PermitAll;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUserDbService userService;

    @PostMapping("/crearUsuario")
    @PermitAll
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>("Guardado con exito", HttpStatus.CREATED);
    }
}
