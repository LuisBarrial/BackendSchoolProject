package com.ProyectoColegio.backend.domain.service;


import com.ProyectoColegio.backend.domain.model.Calificaciones;

import java.util.List;

public interface ICalificacionService {
    public List<Calificaciones> findAll();

    public Calificaciones findCalificacionesByIdProfesorAndIdEstudianteAndIdNota(Long profesorId, Long estudianteId, Long notaCursoId, Long notaEstudianteId);

    public void delete(Long id);

    public Calificaciones save(Calificaciones calificaciones);


}
