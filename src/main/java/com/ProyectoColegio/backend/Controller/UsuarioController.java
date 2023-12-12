package com.ProyectoColegio.backend.Controller;

import com.ProyectoColegio.backend.domain.model.DTO.UsuarioDTO;
import com.ProyectoColegio.backend.domain.model.DTO.UsuarioPostDTO;
import com.ProyectoColegio.backend.domain.model.Estudiante;
import com.ProyectoColegio.backend.domain.model.Rol;
import com.ProyectoColegio.backend.domain.model.Usuario;
import com.ProyectoColegio.backend.domain.repo.INotasDAO;
import com.ProyectoColegio.backend.domain.service.IEstudianteService;
import com.ProyectoColegio.backend.domain.service.IMatriculaService;
import com.ProyectoColegio.backend.domain.service.IRolService;
import com.ProyectoColegio.backend.domain.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/usuario",produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {

    @Autowired
    private IRolService iRolService;

    @Autowired
    private IUsuarioService iUsuarioService;

    @Autowired
    private IEstudianteService iEstudianteService;

    @Autowired
    private IMatriculaService iMatriculaService;

    @Autowired
    private INotasDAO iNotasDAO;

    @PostMapping
    public ResponseEntity<UsuarioPostDTO> saveUsuario(@RequestBody Usuario usuario){

        usuario.setListaRol(Arrays.asList(iRolService.findById(1L)));
        iUsuarioService.save(usuario);
       return ResponseEntity.ok(new UsuarioPostDTO(usuario.getNombre(), usuario.getCorreo(), usuario.getDni()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> delete (@PathVariable("id")  Long id){
        Usuario usuario = iUsuarioService.findById(id);
        Long id2 = iMatriculaService.findMatriculaporIdEstudiante(id).getId();
        iMatriculaService.delete(id2);
        iEstudianteService.delete(id);
        iUsuarioService.delete(id);

        return ResponseEntity.ok(usuario);
    }

    @PutMapping
    public ResponseEntity<String> cambiarUsario(@RequestParam Long id, @RequestParam String clave){

        Usuario usuario = iUsuarioService.findById(id);

        usuario.setClave(clave);

        iUsuarioService.save(usuario);

        return ResponseEntity.ok("La Clave se ha Modificado Correctamente");



    }


}
