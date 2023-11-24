package com.ProyectoColegio.backend.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
@Entity
@Table
public class HorarioEstudiante {

    @Id
    @OneToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;


    private String nombreEstudiante;


    @ManyToOne
    private Curso curso;

    @ManyToOne
    @JoinColumn(name= "id_salon",foreignKey = @ForeignKey(name = "fk_salon_horarioE"))
    private Salon salon;

    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "El formato debe ser hh:mm")
    private String horaInicio;

    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "El formato debe ser hh:mm")
    private String horaFin;

}
