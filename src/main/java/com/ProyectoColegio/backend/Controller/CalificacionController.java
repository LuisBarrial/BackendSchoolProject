package com.ProyectoColegio.backend.Controller;

import com.ProyectoColegio.backend.domain.model.*;
import com.ProyectoColegio.backend.domain.model.DTO.CalificacionesDTO;
import com.ProyectoColegio.backend.domain.service.ICalificacionService;
import com.ProyectoColegio.backend.domain.service.ICursoService;
import com.ProyectoColegio.backend.domain.service.IEstudianteService;
import com.ProyectoColegio.backend.domain.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("calificacion")
public class CalificacionController {

    @Autowired
    private ICalificacionService iCalificacionService;

    @Autowired
    private IEstudianteService iEstudianteService;

    @Autowired
    private ICursoService iCursoService;

    @Autowired
    private IProfesorService iProfesorService;

    @GetMapping
    public ResponseEntity<Calificaciones> getCalificacion(){
        Calificaciones c = iCalificacionService.findCalificacionesByIdProfesorAndIdEstudianteAndIdNota(26L,19L,3L,19L);
        return ResponseEntity.ok(c);
    }

    @PostMapping
    public ResponseEntity<Calificaciones> addCalificaciones(@RequestBody CalificacionesDTO calificacionesDTO){
        Curso c = iCursoService.findById(calificacionesDTO.cursoId());
        Profesor p = iProfesorService.findById(calificacionesDTO.idProfesor());
        Estudiante e = iEstudianteService.findById(calificacionesDTO.idEstudiante());
        Calificaciones calificaciones = new Calificaciones();
        calificaciones.setEstudiante(e);
        calificaciones.setProfesor(p);
        Nota nota = new Nota();
        nota.setEstudiante(e);
        nota.setCurso(c);
      /*  nota.setEF(calificacionesDTO.EF());
        nota.setRF(calificacionesDTO.RF());
        nota.setR1(calificacionesDTO.R1());
        nota.setE1(calificacionesDTO.E1());
        nota.setE2(calificacionesDTO.E2());
        nota.setE3(calificacionesDTO.E3()); */
        calificaciones.setNota(nota);
        return ResponseEntity.ok(iCalificacionService.save(calificaciones));
    }
}
