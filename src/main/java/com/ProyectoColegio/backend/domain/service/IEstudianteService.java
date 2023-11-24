package com.ProyectoColegio.backend.domain.service;


import com.ProyectoColegio.backend.domain.model.Estudiante;
import com.ProyectoColegio.backend.domain.model.Usuario;

import java.util.List;

public interface IEstudianteService {

    public List<Estudiante> findAll();

    public Estudiante findById(Long id);

    public Estudiante save(Estudiante e);

    public void delete(Long id);

}
