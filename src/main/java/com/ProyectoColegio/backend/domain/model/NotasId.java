package com.ProyectoColegio.backend.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class NotasId implements Serializable {
    private Estudiante estudiante;
    private Curso curso;

}
