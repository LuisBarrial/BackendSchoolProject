package com.ProyectoColegio.backend.Controller;

import com.ProyectoColegio.backend.domain.model.Curso;
import com.ProyectoColegio.backend.domain.model.DTO.NotasDTO;
import com.ProyectoColegio.backend.domain.model.DTO.NotasDTOPut;
import com.ProyectoColegio.backend.domain.model.Estudiante;
import com.ProyectoColegio.backend.domain.model.Nota;
import com.ProyectoColegio.backend.domain.model.NotasId;
import com.ProyectoColegio.backend.domain.repo.INotasDAO;
import com.ProyectoColegio.backend.domain.service.ICursoService;
import com.ProyectoColegio.backend.domain.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notas")
public class NotasController {

    @Autowired
    private INotasDAO iNotasDAO;

    @Autowired
    private IEstudianteService iEstudianteService;

    @Autowired
    private ICursoService iCursoService;

    @GetMapping
    public ResponseEntity<List<Nota>> obtenernotas(@RequestParam Long idEstudiante){
        return ResponseEntity.ok(iNotasDAO.getNotasdeEstudiante(idEstudiante));
    }

    @PostMapping ResponseEntity<Nota> guardarnotas(@RequestBody NotasDTO notaDTO){
        Estudiante e = iEstudianteService.findById(notaDTO.idEstudiante());
        Curso c = iCursoService.findById(notaDTO.cursoId());
        Nota nota = new Nota();
        nota.setEstudiante(e);
        nota.setCurso(c);
        nota.setEf(notaDTO.ef());
        nota.setRf(notaDTO.rf());
        nota.setR1(notaDTO.r1());
        nota.setE1(notaDTO.e1());
        nota.setE2(notaDTO.e2());
        nota.setE3(notaDTO.e3());
        System.out.println(nota);
        return ResponseEntity.ok(iNotasDAO.save(nota));
    }
    @PutMapping
    public ResponseEntity<List<NotasDTOPut>> actualizarnotas(@RequestBody List<NotasDTOPut> notaDTO,@RequestParam Long id){
        Estudiante e = iEstudianteService.findById(id);
        System.out.println(
                notaDTO
        );
        notaDTO.forEach((elemento)->{
            NotasId notasId = new NotasId();
            notasId.setCurso(elemento.curso());
            notasId.setEstudiante(e);
            Nota nota = iNotasDAO.findById(notasId).orElse(null);
            nota.setE1(elemento.e1());
            nota.setE2(elemento.e2());
            nota.setE3(elemento.e3());
            nota.setEf(elemento.ef());
            nota.setR1(elemento.r1());
            nota.setRf(elemento.rf());
            iNotasDAO.save(nota);

        });
        return ResponseEntity.ok(notaDTO);
    }





}
