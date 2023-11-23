package com.ProyectoColegio.backend.domain.model.DAO;

import jakarta.validation.constraints.NotNull;

public record EstudianteDAO (
        @NotNull
        Long id,
        String nombre,
        String grado
){
}
