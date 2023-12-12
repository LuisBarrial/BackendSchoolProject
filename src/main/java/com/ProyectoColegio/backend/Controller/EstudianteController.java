package com.ProyectoColegio.backend.Controller;

import com.ProyectoColegio.backend.domain.model.*;
import com.ProyectoColegio.backend.domain.model.DTO.EstudianteDTO;
import com.ProyectoColegio.backend.domain.repo.INotasDAO;
import com.ProyectoColegio.backend.domain.service.IEstudianteService;
import com.ProyectoColegio.backend.domain.service.IMatriculaService;
import com.ProyectoColegio.backend.domain.service.IRolService;
import com.ProyectoColegio.backend.domain.service.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "estudiante",produces = MediaType.APPLICATION_JSON_VALUE)
public class EstudianteController {


    @Autowired
    private IEstudianteService iEstudianteService;

    @Autowired
    private IUsuarioService iUsuarioService;

    @Autowired
    private IMatriculaService iMatriculaService;

    @Autowired
    private INotasDAO iNotasDAO;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private IRolService iRolService;

    @PostMapping
    public ResponseEntity<Estudiante> saveEstudiante( @RequestBody Estudiante e){
        Usuario usuario = new Usuario();
        usuario.setListaRol(Arrays.asList(iRolService.findById(2L)));
        usuario.setClave(bCryptPasswordEncoder.encode(e.getDni()));
        e.setUsuario(usuario);
        return ResponseEntity.ok(iEstudianteService.save(e));
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> getEstudiante(){
         List<Estudiante> entity = iEstudianteService.findAll();
         return ResponseEntity.ok(entity);
    }

    @GetMapping("usuario")
    public ResponseEntity<List<Estudiante>> getEstudiantesporId(@RequestParam Long id){
        String grado = iEstudianteService.findById(id).getGrado();
        List<Estudiante> entity = iEstudianteService.findByGrado(grado);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("find")
    public ResponseEntity<Estudiante> getEstudianteporId(@RequestParam Long id){
        Estudiante estudiante = iEstudianteService.findById(id);
        return ResponseEntity.ok(estudiante);
    }

    @GetMapping("grado")
    public ResponseEntity<List<Estudiante>> getEstudiantesporId(@RequestParam String grado){
        List<Estudiante> entity = iEstudianteService.findByGrado(grado);
        return ResponseEntity.ok(entity);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEstudiante(@PathVariable("id") Long id){
        List<Nota> notas = iNotasDAO.getNotasdeEstudiante(id);
        Matricula m =  iMatriculaService.findMatriculaporIdEstudiante(id);
        iNotasDAO.deleteAll(notas);
        iMatriculaService.delete(m.getId());
        iEstudianteService.delete(id);
        iUsuarioService.delete(id);
        return ResponseEntity.ok("Eliminado");
    }

    @PutMapping
    public ResponseEntity<String> ModificarEstudiante(@RequestBody @Valid EstudianteDTO estudiante){

        Estudiante estudiante1 = iEstudianteService.findById(estudiante.id());
        System.out.println(estudiante1);
        estudiante1.setGrado(estudiante.grado());
        System.out.println(estudiante1.getGrado()+" Grado");
        estudiante1.setNombre(estudiante.nombre());
        iEstudianteService.save(estudiante1);
        System.out.println(iEstudianteService.findById(estudiante.id()));
        System.out.println(estudiante1);
        return ResponseEntity.ok("Actualizado");
    }


}
