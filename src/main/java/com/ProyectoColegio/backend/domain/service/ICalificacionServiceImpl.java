package com.ProyectoColegio.backend.domain.service;

import com.ProyectoColegio.backend.domain.model.Calificaciones;
import com.ProyectoColegio.backend.domain.model.CalificacionesId;
import com.ProyectoColegio.backend.domain.repo.ICalificacionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICalificacionServiceImpl implements ICalificacionService{

    @Autowired
    private ICalificacionDAO iCalificacionDAO;

    @Override
    public List<Calificaciones> findAll() {
        return iCalificacionDAO.findAll();
    }

    @Override
    public Calificaciones findCalificacionesByIdProfesorAndIdEstudianteAndIdNota(Long profesorId, Long estudianteId, Long notaCursoId, Long notaEstudianteId) {
        return (Calificaciones) iCalificacionDAO.findCalificacionesByIdProfesorAndIdEstudianteAndIdNota(profesorId,estudianteId,notaCursoId,notaEstudianteId);
    }

    @Override
    public void delete(Long id) {

    }


    @Override
    public Calificaciones save(Calificaciones calificaciones) {
        return iCalificacionDAO.save(calificaciones);
    }
}
