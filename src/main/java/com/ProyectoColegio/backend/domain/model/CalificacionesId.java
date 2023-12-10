package com.ProyectoColegio.backend.domain.model;

import com.ProyectoColegio.backend.domain.model.Estudiante;
import com.ProyectoColegio.backend.domain.model.Profesor;
import lombok.AllArgsConstructor;

import java.io.Serializable;

public class CalificacionesId implements Serializable {
    private Profesor profesor;
    private Estudiante estudiante;
    private Nota nota;

}
