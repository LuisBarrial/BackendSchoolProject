package com.ProyectoColegio.backend.domain.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "respuesta_tramite")
@Entity
public class RespuestaTramite {

    @Id
    @OneToOne
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;

    private String tipoTramite;

    @Enumerated(EnumType.STRING)
    private EstadoTramite estadoTramite= EstadoTramite.ESPERA;
}
