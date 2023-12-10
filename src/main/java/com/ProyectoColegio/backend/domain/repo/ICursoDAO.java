package com.ProyectoColegio.backend.domain.repo;

import com.ProyectoColegio.backend.domain.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoDAO extends JpaRepository<Curso,Long> {
}
