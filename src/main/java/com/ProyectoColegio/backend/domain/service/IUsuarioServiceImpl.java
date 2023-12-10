package com.ProyectoColegio.backend.domain.service;

import com.ProyectoColegio.backend.domain.model.Usuario;
import com.ProyectoColegio.backend.domain.repo.IUsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IUsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private IUsuarioDAO iUsuarioDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
    @Transactional(readOnly = true)
    public UserDetails findByCorreo(String correo) {
        return iUsuarioDAO.findByCorreo(correo);
    }

    @Override
    @Transactional
    public Usuario save(Usuario e)   {
        e.setClave(bCryptPasswordEncoder.encode(e.getClave()));
         return iUsuarioDAO.save(e);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        iUsuarioDAO.deleteById(id);
    }
}
