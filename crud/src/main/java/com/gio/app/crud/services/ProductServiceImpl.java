package com.gio.app.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gio.app.crud.entities.Product;
import com.gio.app.crud.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true) 
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Optional<Product> delete(Long id) {
        Optional<Product> productOp = productRepository.findById(id);
        productOp.ifPresent(p -> {
            productRepository.delete(p);
        });
        return productOp;
    }

    @Override
    @Transactional
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> productOp = productRepository.findById(id);
        if(productOp.isPresent()) {
            Product p = productOp.orElseThrow();
            p.setName(product.getName());
            p.setDescripcion(product.getDescripcion());
            p.setPrice(product.getPrice());
            p.setSku(product.getSku());
            return Optional.of(productRepository.save(p));
        }
        return productOp;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsBySku(String sku) {
        return productRepository.existsBySku(sku);
    }

}
