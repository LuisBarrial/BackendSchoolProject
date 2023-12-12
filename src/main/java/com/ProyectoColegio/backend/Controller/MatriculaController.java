package com.ProyectoColegio.backend.Controller;

import com.ProyectoColegio.backend.domain.model.DTO.MatriculaDTO;
import com.ProyectoColegio.backend.domain.model.Matricula;
import com.ProyectoColegio.backend.domain.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("matricula")
@RestController
public class MatriculaController {

    @Autowired
    private IMatriculaService iMatriculaService;

    @GetMapping("")
    public ResponseEntity<List<MatriculaDTO>> GetMatriculaByGrado(@RequestParam String grado){


        List<Matricula> matriculas= iMatriculaService.findMatriculaporGrado(grado);
        List <MatriculaDTO> matriculaDTOS = matriculas.stream().map(data -> new MatriculaDTO(data)).toList();
        return ResponseEntity.ok(matriculaDTOS);
    }

    @GetMapping("usuario")
    public ResponseEntity<MatriculaDTO> GetMatriculaByAlumno(@RequestParam Long id ){


        Matricula matriculas= iMatriculaService.findMatriculaporIdEstudiante(id);
        MatriculaDTO matriculaDTO = new MatriculaDTO(matriculas);
        return ResponseEntity.ok(matriculaDTO);
    }

}
