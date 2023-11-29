package com.ProyectoColegio.backend.domain.service;

import com.ProyectoColegio.backend.domain.model.Consulta;
import com.ProyectoColegio.backend.domain.repo.IConsultaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IConsultaServiceServiceImpl implements IConsultaService {

    @Autowired
    private IConsultaDAO iConsultaDAO;

    @Override
    public List<Consulta> findAll() {
        return iConsultaDAO.findAll();
    }

    @Override
    public Consulta findById(Long id) {
        return iConsultaDAO.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {

        iConsultaDAO.deleteById(id);

    }

    @Override
    public Consulta save(Consulta consulta) {
        return iConsultaDAO.save(consulta);
    }
}
