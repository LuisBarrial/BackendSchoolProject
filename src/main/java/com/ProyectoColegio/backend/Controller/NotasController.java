package com.ProyectoColegio.backend.Controller;

import com.ProyectoColegio.backend.domain.model.Nota;
import com.ProyectoColegio.backend.domain.repo.INotasDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("notas")
public class NotasController {

    @Autowired
    INotasDAO iNotasDAO;


    @GetMapping
    public ResponseEntity<List<Nota>> obtenernotas(@RequestParam Long idEstudiante){
        return ResponseEntity.ok(iNotasDAO.getNotasdeEstudiante(idEstudiante));
    }



}
