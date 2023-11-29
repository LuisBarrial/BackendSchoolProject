package com.ProyectoColegio.backend.domain.model.DTO;

import jakarta.validation.constraints.NotNull;

public record EstudianteDTO (
        @NotNull
        Long id,
        String nombre,
        String grado
){
}
