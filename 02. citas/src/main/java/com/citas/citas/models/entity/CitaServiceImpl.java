package com.citas.citas.models.entity;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citas.citas.models.dao.ICitaDao;
import com.citas.citas.models.service.ICitaService;


@Service
public class CitaServiceImpl implements ICitaService{
    
    @Autowired
    private ICitaDao citaDao;

    @Override
    @Transactional(readOnly = true)
    public Cita findById(Long id) {
        return citaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void create(CitaDTO cita) {
        Cita citaCrear = new Cita();
        citaCrear.setNombre(cita.getNombre());
        citaCrear.setSintomas(cita.getSintomas());
        citaCrear.setNombre_propietario(cita.getNombrePropietario());
        citaCrear.setFecha_cita(new Date());
        citaDao.save(citaCrear);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        citaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cita> findAll() {
        return (List<Cita>) citaDao.findAll();
    }
    
}
