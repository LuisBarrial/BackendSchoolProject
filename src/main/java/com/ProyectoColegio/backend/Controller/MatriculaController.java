package com.ProyectoColegio.backend.Controller;

import com.ProyectoColegio.backend.domain.model.DTO.MatriculaDTO;
import com.ProyectoColegio.backend.domain.model.Matricula;
import com.ProyectoColegio.backend.domain.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("matricula")
@RestController
public class MatriculaController {

    @Value("${api.security.secret}")
    public String secret;

    @Autowired
    private IMatriculaService iMatriculaService;

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> GetMatriculaByGrado(@RequestParam String grado){


        List<Matricula> matriculas= iMatriculaService.findMatriculaporGrado(grado);
        List <MatriculaDTO> matriculaDTOS = matriculas.stream().map(data -> new MatriculaDTO(data)).toList();
        System.out.println(secret);
        return ResponseEntity.ok(matriculaDTOS);
    }

}
