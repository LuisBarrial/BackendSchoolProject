package com.ProyectoColegio.backend.domain.service;

import com.ProyectoColegio.backend.domain.model.Curso;

import java.util.List;

public interface ICursoService {

    public List<Curso> findAll();

    public Curso findById(Long id);

    public void delete(Long id);

    public Curso save(Curso curso);
}
