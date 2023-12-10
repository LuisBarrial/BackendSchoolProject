package com.ProyectoColegio.backend.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.ast.Not;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "calificaciones")
@EqualsAndHashCode
@Table(name = "calificacion")
@IdClass(CalificacionesId.class) // Clase que representa la clave primaria compuesta
public class Calificaciones {

    private String nombreProfesor;
    private String nombreEstudiante;
    private String nombreCurso;

    @Id
    @ManyToOne
    @JoinColumn(name = "DNI_profesor", insertable = false, updatable = false)
    private Profesor profesor;

    @Id
    @ManyToOne
    @JoinColumn(name = "DNI_estudiante", insertable = false, updatable = false)
    private Estudiante estudiante;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private Nota nota;

    private int valor;

}
