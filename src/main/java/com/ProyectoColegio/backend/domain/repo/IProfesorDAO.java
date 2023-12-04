package com.ProyectoColegio.backend.domain.repo;

import com.ProyectoColegio.backend.domain.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfesorDAO extends JpaRepository<Profesor,Long> {
}
