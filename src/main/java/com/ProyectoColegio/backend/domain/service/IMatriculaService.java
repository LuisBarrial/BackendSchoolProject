package com.ProyectoColegio.backend.domain.service;

import com.ProyectoColegio.backend.domain.model.Estudiante;
import com.ProyectoColegio.backend.domain.model.Matricula;

import java.util.List;

public interface IMatriculaService {

    public List<Matricula> findAll();

    public List<Matricula> findMatriculaporGrado(String grado);

    public Matricula findById(Long id);

    public Matricula save(Matricula e);

    public void delete(Long id);
}
