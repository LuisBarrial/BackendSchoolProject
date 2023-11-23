package com.ProyectoColegio.backend.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@Entity(name = "estudiante")
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 8, max = 8,message = "El DNI debe tener 8 digitos")
    private String dni;

    @Email(message = "Correo Invalido")
    private String correo;

    private String nombre;

    private String grado;

}
