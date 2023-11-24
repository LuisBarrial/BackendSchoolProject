package com.ProyectoColegio.backend.domain.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
@Entity
@Table
public class DetalleMatricula {

    @Id
    @OneToOne
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private int horas;

    private String nombreCurso;



}
