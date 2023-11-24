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
public class HorarioProfesor {

    @Id
    @OneToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    private String nombreProfesor;

    @ManyToOne
    private Curso curso;

    @ManyToOne
    @JoinColumn(name= "id_salon",foreignKey = @ForeignKey(name = "fk_salon_horarioP"))
    private Salon salon;

    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "El formato debe ser hh:mm")
    private String horaInicio;

    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "El formato debe ser hh:mm")
    private String horaFin;


}
