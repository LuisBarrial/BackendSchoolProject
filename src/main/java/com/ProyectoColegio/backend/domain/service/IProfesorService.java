package com.ProyectoColegio.backend.domain.service;

import com.ProyectoColegio.backend.domain.model.Profesor;

import java.util.List;

public interface IProfesorService {

    public List<Profesor> findAll();

    public Profesor findById(Long id);

    public Profesor save(Profesor e);

    public void delete(Long id);
}
