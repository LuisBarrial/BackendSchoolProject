package com.ProyectoColegio.backend.domain.repo;

import com.ProyectoColegio.backend.domain.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudianteDAO extends JpaRepository<Estudiante,Long> {
}
