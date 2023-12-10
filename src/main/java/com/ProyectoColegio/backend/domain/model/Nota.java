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


    @ManyToOne(cascade = CascadeType.ALL, optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_id")
    @Id
    @JsonIgnore
    private Estudiante estudiante;

    @Id
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private double E1;

    private double E2;

    private double R1;

    private double E3;

    private double EF;

    private double RF;

}
