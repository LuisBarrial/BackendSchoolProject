package com.ProyectoColegio.backend.domain.service;

import com.ProyectoColegio.backend.domain.model.Curso;
import com.ProyectoColegio.backend.domain.repo.ICursoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICursoServiceImpl implements ICursoService{

    @Autowired
    private ICursoDAO iCursoDAO;

    @Override
    public List<Curso> findAll() {
        return iCursoDAO.findAll();
    }

    @Override
    public Curso findById(Long id) {
        return iCursoDAO.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        iCursoDAO.deleteById(id);
    }

    @Override
    public Curso save(Curso curso) {
        return iCursoDAO.save(curso);
    }
}
