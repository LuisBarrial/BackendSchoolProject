package com.ProyectoColegio.backend.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "usuario")
@Table(name = "usuario")
@EqualsAndHashCode(of = "id")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 8, max = 8,message = "el dni debe tener 8 digitos")
    private String dni;

    private String nombre;

    @Email(message = "Debe ingresar un correo valido")
    private String correo;

    private String clave;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id"))
    private List<Rol> listaRol;
}
