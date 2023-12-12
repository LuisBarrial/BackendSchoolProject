package com.ProyectoColegio.backend.Controller;

import com.ProyectoColegio.backend.domain.model.Consulta;
import com.ProyectoColegio.backend.domain.model.Curso;
import com.ProyectoColegio.backend.domain.model.DTO.ConsultaDTO;
import com.ProyectoColegio.backend.domain.model.Nota;
import com.ProyectoColegio.backend.domain.repo.INotasDAO;
import com.ProyectoColegio.backend.domain.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("curso")
public class CursoController {

    @Autowired
    private ICursoService iCursoService;

    @Autowired
    private INotasDAO iNotasDAO;

    @PostMapping
    public ResponseEntity<Curso> guardar(@RequestBody Curso curso){

        iCursoService.save(curso);

        return ResponseEntity.ok(curso);
    }

    @GetMapping
    public ResponseEntity<List<Curso>> obtener(){

        List<Curso> curso = iCursoService.findAll();

        return ResponseEntity.ok(curso);
    }

    @PutMapping
    public ResponseEntity<Curso> editar(@RequestBody Curso cursoe){
        Curso curso = iCursoService.findById(cursoe.getId());
        curso.setNombre(cursoe.getNombre());
        curso.setHoras(cursoe.getHoras());
        curso.setTipoEvaluacion(cursoe.getTipoEvaluacion());
        iCursoService.save(curso);

        return ResponseEntity.ok(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> eliminar(@PathVariable("id") Long id){
        Curso curso= iCursoService.findById(id);

        List<Nota> notas = iNotasDAO.getNotasdeCurso(id);
        iNotasDAO.deleteAll(notas);
        iCursoService.delete(id);
        return ResponseEntity.ok(curso);
    }


}
