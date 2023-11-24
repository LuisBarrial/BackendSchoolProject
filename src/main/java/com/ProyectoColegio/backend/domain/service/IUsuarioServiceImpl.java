package com.ProyectoColegio.backend.domain.service;

import com.ProyectoColegio.backend.domain.model.Usuario;
import com.ProyectoColegio.backend.domain.repo.IUsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IUsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private IUsuarioDAO iUsuarioDAO;

    @Override
    @Transactional

    public List<Usuario> findAll() {
       return iUsuarioDAO.findAll();
    }

    @Override
    @Transactional
    public Usuario findById(Long id) {
        return iUsuarioDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Usuario save(Usuario e) {
        return iUsuarioDAO.save(e);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        iUsuarioDAO.deleteById(id);
    }
}
