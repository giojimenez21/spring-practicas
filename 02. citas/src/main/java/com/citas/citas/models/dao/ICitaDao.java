package com.citas.citas.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.citas.citas.models.entity.Cita;

public interface ICitaDao extends CrudRepository<Cita, Long>{ }
