package com.ProyectoColegio.backend.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class HorarioProfesor {

    @Id
    @OneToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "DNI_profesor", referencedColumnName = "dni")
    private Profesor profesor;

    private String nombreProfesor;

    @OneToMany(fetch = FetchType.EAGER)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "salon_id")
    private Salon salon;

    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "El formato debe ser hh:mm")
    private String horaInicio;

    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "El formato debe ser hh:mm")
    private String horaFin;


}
