package com.ProyectoColegio.backend.domain.repo;

import com.ProyectoColegio.backend.domain.model.HorarioProfesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHorarioProfesorDAO extends JpaRepository<HorarioProfesor,Long> {
}
