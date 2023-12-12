package com.ProyectoColegio.backend.domain.repo;

import com.ProyectoColegio.backend.domain.model.Nota;
import com.ProyectoColegio.backend.domain.model.NotasId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface  INotasDAO extends JpaRepository<Nota, NotasId> {

    @Query(value ="Select * from nota where estudiante_id = ?" ,nativeQuery = true)
    public List<Nota> getNotasdeEstudiante(Long id);

    @Query(value ="Select * from nota where curso_id = ?" ,nativeQuery = true)
    public List<Nota> getNotasdeCurso(Long id);

}
