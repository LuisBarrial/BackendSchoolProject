package com.ProyectoColegio.backend.domain.model.DTO;

import com.ProyectoColegio.backend.domain.model.Matricula;

public record MatriculaDTO(Long id, String fecha, String estado, String nombre) {
    public MatriculaDTO(Matricula matricula){
        this(matricula.getId(), matricula.getFecha(), matricula.getEstado(), matricula.getNombreEstudiante());
    }
}
