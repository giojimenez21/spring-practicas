package com.gio.app.crud.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gio.app.crud.services.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ExistsByUsernameValidation implements ConstraintValidator<ExistsByUsername, String>{

    @Autowired
    private UserService service;


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(service == null) return true;
        return !service.existsByUsername(value);
    }

}
