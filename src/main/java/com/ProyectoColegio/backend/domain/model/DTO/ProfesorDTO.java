package com.ProyectoColegio.backend.domain.model.DTO;

import jakarta.validation.constraints.NotNull;

public record ProfesorDTO(
        @NotNull
        Long id,
        String nombre,
        String area
) {
}
