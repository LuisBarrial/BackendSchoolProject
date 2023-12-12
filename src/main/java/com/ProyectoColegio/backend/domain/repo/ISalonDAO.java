package com.ProyectoColegio.backend.domain.repo;

import com.ProyectoColegio.backend.domain.model.Salon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISalonDAO extends JpaRepository<Salon,Long> {
}
