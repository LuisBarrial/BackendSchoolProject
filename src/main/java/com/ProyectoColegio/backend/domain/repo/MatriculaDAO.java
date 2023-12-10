package com.ProyectoColegio.backend.domain.repo;

import com.ProyectoColegio.backend.domain.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatriculaDAO extends JpaRepository<Matricula,Long> {

    @Query(value ="CALL obtenerMatriculaPorGrado (?)" ,nativeQuery = true)
    public List<Matricula> findMatriculaByGrado(String nombre);



}
