package com.ProyectoColegio.backend.domain.repo;

import com.ProyectoColegio.backend.domain.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolDAO extends JpaRepository<Rol,Long> {
}
