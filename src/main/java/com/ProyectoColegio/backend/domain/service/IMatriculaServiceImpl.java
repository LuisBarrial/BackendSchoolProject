package com.ProyectoColegio.backend.domain.service;

import com.ProyectoColegio.backend.domain.model.Matricula;
import com.ProyectoColegio.backend.domain.repo.MatriculaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IMatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private MatriculaDAO matriculaDAO;


    @Override
    public List<Matricula> findAll() {
        return matriculaDAO.findAll();
    }

    @Override
    public List<Matricula> findMatriculaporGrado(String grado) {
        return matriculaDAO.findMatriculaByGrado(grado);
    }

    @Override
    public Matricula findMatriculaporIdEstudiante(Long id) {
        return matriculaDAO.findMatriculaByIdEstudiante(id);
    }

    @Override
    public Matricula findById(Long id) {
        return matriculaDAO.findById(id).orElse(null);
    }

    @Override
    public Matricula save(Matricula e) {
        return matriculaDAO.save(e);
    }

    @Override
    public void delete(Long id) {

        matriculaDAO.deleteById(id);
    }
}
