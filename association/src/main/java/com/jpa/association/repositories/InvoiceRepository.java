package com.jpa.association.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jpa.association.entities.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
