package com.ProyectoColegio.backend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@Entity(name = "estudiante")
@Table(name = "estudiante")
@EqualsAndHashCode
public class Estudiante implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, optional = false,fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    @MapsId
    @JsonIgnore
    private Usuario usuario;

    /*
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario; */


    @Size(min = 8, max = 8,message = "El DNI debe tener 8 digitos")
    private String dni;

    @Email(message = "Correo Invalido")
    private String correo;

    private String nombre;

    private String grado;

    @PrePersist
    public void prePersist() {
        if(!usuario.getListaRol().isEmpty()) {
            this.usuario.setDni(dni);
            this.usuario.setCorreo(correo);
            this.usuario.setNombre(nombre);
        }

    }

    }
