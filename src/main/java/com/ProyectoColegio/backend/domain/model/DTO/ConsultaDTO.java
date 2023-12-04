package com.ProyectoColegio.backend.domain.model.DTO;

import com.ProyectoColegio.backend.domain.model.Consulta;

public record ConsultaDTO(Long id, String pregunta, String respuesta, String estado) {

        public ConsultaDTO(Consulta consulta){
            this(consulta.getId(),consulta.getPregunta(),consulta.getRespuesta(),consulta.getEstado());
        }

}
