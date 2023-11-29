package com.ProyectoColegio.backend.domain.repo;

import com.ProyectoColegio.backend.domain.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConsultaDAO extends JpaRepository<Consulta,Long> {
}
