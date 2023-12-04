package com.ProyectoColegio.backend.domain.service;

import com.ProyectoColegio.backend.domain.model.Profesor;
import com.ProyectoColegio.backend.domain.repo.IProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IProfesorServiceImpl implements IProfesorService{

    @Autowired
    private IProfesorDAO iProfesorDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Profesor> findAll() {
        return iProfesorDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Profesor findById(Long id) {
        return iProfesorDAO.findById(id).orElse(null);
    }

    @Override
    public Profesor save(Profesor e) {
        return iProfesorDAO.save(e);
    }

    @Override
    public void delete(Long id) {
        iProfesorDAO.deleteById(id);
    }
}
