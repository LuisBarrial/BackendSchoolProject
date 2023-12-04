package com.ProyectoColegio.backend.domain.service;

import com.ProyectoColegio.backend.domain.model.Estudiante;
import com.ProyectoColegio.backend.domain.repo.IEstudianteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public class IEstudianteServiceImpl implements IEstudianteService{

    @Autowired
    private IEstudianteDAO iEstudianteDAO;

    @Override
    @Transactional
    public List<Estudiante> findAll() {
      return  iEstudianteDAO.findAll();
    }

    @Override
    public List<Estudiante> findByGrado(String grado) {
        return iEstudianteDAO.getListUsers(grado);
    }

    @Override
    @Transactional
    public Estudiante findById(Long id) {
       return iEstudianteDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Estudiante save(Estudiante e) {
        return iEstudianteDAO.save(e);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        iEstudianteDAO.deleteById(id);

    }
}
