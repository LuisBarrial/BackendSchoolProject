package com.ProyectoColegio.backend.domain.repo;

import com.ProyectoColegio.backend.domain.model.Calificaciones;
import com.ProyectoColegio.backend.domain.model.CalificacionesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICalificacionDAO extends JpaRepository<Calificaciones, CalificacionesId> {

    @Query(value = "SELECT * FROM calificacion WHERE dni_profesor = ?1 AND dni_estudiante = ?2 AND nota_curso_id = ?3 AND nota_estudiante_id = ?4", nativeQuery = true)
    public Calificaciones findCalificacionesByIdProfesorAndIdEstudianteAndIdNota(Long profesorId, Long estudianteId, Long notaCursoId, Long notaEstudianteId);

}
