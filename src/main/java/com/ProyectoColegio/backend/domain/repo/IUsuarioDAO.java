package com.ProyectoColegio.backend.domain.repo;

import com.ProyectoColegio.backend.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario,Long> {
    UserDetails findByCorreo(String correo);
}
