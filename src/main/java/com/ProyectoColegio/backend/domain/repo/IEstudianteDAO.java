package com.ProyectoColegio.backend.domain.repo;

import com.ProyectoColegio.backend.domain.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEstudianteDAO extends JpaRepository<Estudiante,Long> {

    @Query(value = "CALL pa_buscar_alumno (?)",nativeQuery = true)
    public List<Estudiante> getListUsers(String grado);

}
