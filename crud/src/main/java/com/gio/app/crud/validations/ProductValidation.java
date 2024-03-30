package com.gio.app.crud.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gio.app.crud.entities.Product;

@Component
public class ProductValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.product.name");
        if(product.getDescripcion() == null || product.getDescripcion().isBlank()) {
            errors.rejectValue("description", "NotEmpty.description.name");
        }
    }

}
