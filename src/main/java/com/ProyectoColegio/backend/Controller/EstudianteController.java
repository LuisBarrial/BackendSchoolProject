package com.ProyectoColegio.backend.Controller;

import com.ProyectoColegio.backend.domain.model.DAO.EstudianteDAO;
import com.ProyectoColegio.backend.domain.model.Estudiante;
import com.ProyectoColegio.backend.domain.service.IEstudianteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "estudiante",produces = MediaType.APPLICATION_JSON_VALUE)
public class EstudianteController {

    @Autowired
    private IEstudianteService iEstudianteService;

    @PostMapping
    public ResponseEntity<Estudiante> saveEstudiante( @RequestBody Estudiante e){


        return ResponseEntity.ok(iEstudianteService.save(e));
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> getEstudiante(){
         List<Estudiante> entity = iEstudianteService.findAll();
         return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEstudiante(@PathVariable("id") Long id){
        iEstudianteService.delete(id);
        return ResponseEntity.ok("Eliminado");
    }

    @PutMapping
    public ResponseEntity<String> ModificarEstudiante(@RequestBody @Valid EstudianteDAO estudiante){

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
