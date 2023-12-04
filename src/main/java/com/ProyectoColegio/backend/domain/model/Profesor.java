package com.ProyectoColegio.backend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "profesor")
@Table(name = "profesor")
@EqualsAndHashCode(of = "id")
public class Profesor implements Serializable {
/*
    @Id
    @Column(name = "id_usuario") // Nombre de la columna que representa la clave primaria de Usuario
    private Long id; // Campo que representa la clave primaria de Usuario

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn // Utiliza la misma clave primaria que la entidad Usuario
    private Usuario usuario; */

/*
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @MapsId
    @JsonIgnore
    private Usuario usuario;


    private String nombre;

    @Size(min = 8, max = 8,message = "El DNI debe tener 8 digitos")
    private String dni;

    @Email(message = "debe ingresar un correo Invalido")
    private String correo;

    private String area;

    @PrePersist
    public void prePersist() {
        if(!usuario.getListaRol().isEmpty()) {
            this.usuario.setDni(dni);
            this.usuario.setCorreo(correo);
            this.usuario.setNombre(nombre);
            this.usuario.setClave(dni); // Asignar la clave aquí
        }

    }

}
