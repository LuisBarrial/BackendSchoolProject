package com.ProyectoColegio.backend.domain.model.DTO;

public record HorarioProfesorDTO(Long idProfesor, String nombre, String dias, Long idCurso, Long idSalon, String horainicio , String horafinal) {
}
