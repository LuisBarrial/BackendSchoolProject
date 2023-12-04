package com.ProyectoColegio.backend.Controller;

import com.ProyectoColegio.backend.domain.model.DTO.EstudianteDTO;
import com.ProyectoColegio.backend.domain.model.DTO.ProfesorDTO;
import com.ProyectoColegio.backend.domain.model.Estudiante;
import com.ProyectoColegio.backend.domain.model.Profesor;
import com.ProyectoColegio.backend.domain.model.Usuario;
import com.ProyectoColegio.backend.domain.service.IProfesorService;
import com.ProyectoColegio.backend.domain.service.IRolService;
import com.ProyectoColegio.backend.domain.service.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("profesor")
public class ProfesorController {

    @Autowired
    private IProfesorService iProfesorService;

    @Autowired
    private IUsuarioService iUsuarioService;

    @Autowired
    private IRolService iRolService;

    @PostMapping
    public ResponseEntity<Profesor> saveProfesor(@RequestBody Profesor e){
        Usuario usuario = new Usuario();
        usuario.setListaRol(Arrays.asList(iRolService.findById(3L)));
        e.setUsuario(usuario);
        return ResponseEntity.ok(iProfesorService.save(e));
    }

    @GetMapping
    public ResponseEntity<List<Profesor>> getProfesores(){
        List<Profesor> entity = iProfesorService.findAll();
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfesor(@PathVariable("id") Long id){
        iProfesorService.delete(id);
        return ResponseEntity.ok("Eliminado");
    }

    @PutMapping
    public ResponseEntity<String> ModificarEstudiante(@RequestBody @Valid ProfesorDTO profesorDTO){

        Profesor profesor = iProfesorService.findById(profesorDTO.id());
        profesor.setArea(profesorDTO.area());
        profesor.setNombre(profesorDTO.nombre());

        iProfesorService.save(profesor);
        return ResponseEntity.ok("Actualizado");
    }

}
