package com.ProyectoColegio.backend.domain.service;

import com.ProyectoColegio.backend.domain.model.Rol;

import java.util.List;

public interface IRolService {

    public List<Rol> findAll();

    public Rol findById(Long id);

}
