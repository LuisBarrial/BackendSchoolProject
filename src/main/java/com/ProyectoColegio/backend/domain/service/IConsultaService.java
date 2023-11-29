package com.ProyectoColegio.backend.domain.service;

import com.ProyectoColegio.backend.domain.model.Consulta;

import java.util.List;

public interface IConsultaService {
   public List<Consulta> findAll();

   public Consulta findById(Long id);

   public void delete(Long id);

   public Consulta save(Consulta consulta);
}
