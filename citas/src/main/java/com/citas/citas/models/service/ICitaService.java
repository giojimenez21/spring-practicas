package com.citas.citas.models.service;

import java.util.List;

import com.citas.citas.models.entity.Cita;
import com.citas.citas.models.entity.CitaDTO;

public interface ICitaService {
    public Cita findById(Long id);
    public void create(CitaDTO cita);
    public void delete(Long id);
    public List<Cita> findAll();
}
