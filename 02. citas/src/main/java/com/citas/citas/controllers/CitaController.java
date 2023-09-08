package com.citas.citas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citas.citas.models.entity.Cita;
import com.citas.citas.models.entity.CitaDTO;
import com.citas.citas.models.entity.MessageResponse;
import com.citas.citas.models.service.ICitaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/citas")
public class CitaController {
    
    @Autowired
    private ICitaService citaService;

    @GetMapping("/listarCitas")
    public List<Cita> listarCitas() {
        return citaService.findAll();
    }

    @GetMapping("/buscarCita/{id}")
    public ResponseEntity<Cita> buscarCita(@PathVariable Long id) {
        Cita cita = citaService.findById(id);
        if(cita == null) {
            return new ResponseEntity<>(cita, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Cita>(cita, HttpStatus.OK);
    }

    @DeleteMapping("/eliminarCita/{id}")
    public ResponseEntity<MessageResponse> eliminarCita(@PathVariable Long id) {
        MessageResponse messageResponse;
        Cita citaParaBorrar = citaService.findById(id);
        if(citaParaBorrar == null) {
            messageResponse = new MessageResponse(
                HttpStatus.NOT_FOUND, 
                "No existe ninguna cita con ese id"
            );
            return new ResponseEntity<>(messageResponse, HttpStatus.NOT_FOUND);
        }
        citaService.delete(id);
        messageResponse = new MessageResponse(HttpStatus.OK, "Cita eliminada");
        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }

    @PostMapping("/crearCita")
    public ResponseEntity<MessageResponse> crearCita(
        @Valid @RequestBody CitaDTO citaDTO) {
        citaService.create(citaDTO);
        MessageResponse messageResponse = new MessageResponse(
            HttpStatus.CREATED, 
            "Cita creada."
        );
        return new ResponseEntity<MessageResponse>(
            messageResponse, 
            HttpStatus.CREATED
        );
    }
}
