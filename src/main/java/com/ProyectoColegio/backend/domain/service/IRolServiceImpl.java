package com.ProyectoColegio.backend.domain.service;

import com.ProyectoColegio.backend.domain.model.Rol;
import com.ProyectoColegio.backend.domain.repo.IRolDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IRolServiceImpl implements IRolService{

    @Autowired
    private IRolDAO iRolDAO;

    @Override
    @Transactional
    public List<Rol> findAll() {
        return iRolDAO.findAll();
    }

    @Override
    @Transactional
    public Rol findById(Long id) {
        return iRolDAO.findById(id).orElse(null);
    }
}
