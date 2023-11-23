package com.ProyectoColegio.backend.domain.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "calificaciones")
@Table(name = "calificacion")
public class Calificaciones {

    private String nombreProfesor;
    private String nombreEstudiante;
    private String nombreCurso;

    @Id
    @OneToMany
    @JoinColumn(name = "DNI_profesor", insertable = false, updatable = false)
    private Profesor profesor;

    @Id
    @OneToMany
    @JoinColumn(name = "DNI_estudiante", insertable = false, updatable = false)
    private Estudiante estudiante;

    @Id
    @ManyToOne
    @JoinColumn(name = "COD_curso", insertable = false, updatable = false)
    private Curso curso;

    @Id
    @ManyToOne
    @JoinColumn(name = "COD_nota", insertable = false, updatable = false)
    private Nota nota;

    private int valor;

}
