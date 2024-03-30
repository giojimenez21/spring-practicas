package com.jpa.association.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jpa.association.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
    
}
