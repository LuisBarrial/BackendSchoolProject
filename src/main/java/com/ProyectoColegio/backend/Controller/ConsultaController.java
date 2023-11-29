package com.ProyectoColegio.backend.Controller;

import com.ProyectoColegio.backend.domain.model.Consulta;
import com.ProyectoColegio.backend.domain.model.DTO.ConsultaDTO;
import com.ProyectoColegio.backend.domain.model.Usuario;
import com.ProyectoColegio.backend.domain.service.IConsultaService;
import com.ProyectoColegio.backend.domain.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consulta")
public class ConsultaController {

    @Autowired
    private IConsultaService iConsultaService;
    @Autowired
    private IUsuarioService iUsuarioService;

    @PostMapping
    public ResponseEntity<ConsultaDTO> crear(@RequestBody ConsultaDTO consultaDTO){
        Usuario usuario = iUsuarioService.findById(consultaDTO.id());
        System.out.println(usuario.getListaRol());
        Consulta entity = new Consulta();
        entity.setEstado(consultaDTO.estado());
        entity.setPregunta(consultaDTO.pregunta());
        entity.setRespuesta(consultaDTO.respuesta());
        entity.setIdUsuario(usuario);
        Consulta consulta = iConsultaService.save(entity);


        return ResponseEntity.ok(consultaDTO);


    }
}
