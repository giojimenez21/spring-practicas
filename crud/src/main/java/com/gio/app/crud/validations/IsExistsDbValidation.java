package com.gio.app.crud.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gio.app.crud.services.ProductService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class IsExistsDbValidation implements ConstraintValidator<IsExistsDb, String> {
    @Autowired
    private ProductService productService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(productService == null) return true;
        return !productService.existsBySku(value);
    }

}
