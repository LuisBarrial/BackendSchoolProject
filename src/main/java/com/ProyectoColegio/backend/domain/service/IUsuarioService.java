package com.ProyectoColegio.backend.domain.service;

import com.ProyectoColegio.backend.domain.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    public List<Usuario> findAll();

    public Usuario findById(Long id);

    public Usuario save(Usuario e);

    public void delete(Long id);
}
