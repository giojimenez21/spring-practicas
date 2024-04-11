package com.gio.app.crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.gio.app.crud.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
    boolean existsBySku(String sku);
}
