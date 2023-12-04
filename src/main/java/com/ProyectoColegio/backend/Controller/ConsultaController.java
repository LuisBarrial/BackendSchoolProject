package com.ProyectoColegio.backend.Controller;

import com.ProyectoColegio.backend.domain.model.Consulta;
import com.ProyectoColegio.backend.domain.model.DTO.ConsultaDTO;
import com.ProyectoColegio.backend.domain.model.Usuario;
import com.ProyectoColegio.backend.domain.service.IConsultaService;
import com.ProyectoColegio.backend.domain.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Consulta>> obtener(){

        List<Consulta> consulta = iConsultaService.findAll();

        return ResponseEntity.ok(consulta);
    }

    @PutMapping
    public ResponseEntity<ConsultaDTO> editar(@RequestBody ConsultaDTO consultaDTO){
       Consulta consulta = iConsultaService.findById(consultaDTO.id());
       consulta.setRespuesta(consultaDTO.respuesta());
       iConsultaService.save(consulta);

       return ResponseEntity.ok(consultaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ConsultaDTO> eliminar(@PathVariable("id") Long id){
       Consulta consulta = iConsultaService.findById(id);
       iConsultaService.delete(id);
       return ResponseEntity.ok(new ConsultaDTO(consulta));
    }
}
