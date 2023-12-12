package com.ProyectoColegio.backend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "nota")
@Table(name = "nota")
@IdClass(NotasId.class)
public class Nota {


    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_id")
    @Id
    @JsonIgnore
    private Estudiante estudiante;

    @Id
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private double e1;

    private double e2;

    private double r1;

    private double e3;

    private double ef;

    private double rf;

}
