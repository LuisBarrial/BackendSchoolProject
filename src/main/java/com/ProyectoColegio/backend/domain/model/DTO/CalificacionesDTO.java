package com.ProyectoColegio.backend.domain.model.DTO;

import com.ProyectoColegio.backend.domain.model.Nota;

public record CalificacionesDTO(Long idEstudiante, Long idProfesor, Long cursoId,double E1,

        double E2,

        double R1,

        double E3,

        double EF,

        double RF ) {
}
