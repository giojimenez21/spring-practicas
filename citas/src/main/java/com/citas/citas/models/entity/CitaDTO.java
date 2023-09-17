package com.citas.citas.models.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CitaDTO {
    @NotBlank(message = "El campo nombre es requerido")
    private String nombre;
    @NotBlank(message = "Los sintomas son requeridos")
    private String sintomas;
    @NotBlank(message = "El nombre del propietario es obligatorio")
    private String nombrePropietario;
}
