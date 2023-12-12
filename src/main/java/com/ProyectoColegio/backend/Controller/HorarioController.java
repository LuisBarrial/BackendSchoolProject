package com.ProyectoColegio.backend.Controller;

import com.ProyectoColegio.backend.domain.model.Curso;
import com.ProyectoColegio.backend.domain.model.DTO.HorarioDTOFullCalendar;
import com.ProyectoColegio.backend.domain.model.DTO.HorarioProfesorDTO;
import com.ProyectoColegio.backend.domain.model.DTO.HorarioProfesorDTOGet;
import com.ProyectoColegio.backend.domain.model.HorarioProfesor;
import com.ProyectoColegio.backend.domain.model.Profesor;
import com.ProyectoColegio.backend.domain.model.Salon;
import com.ProyectoColegio.backend.domain.repo.IHorarioProfesorDAO;
import com.ProyectoColegio.backend.domain.repo.ISalonDAO;
import com.ProyectoColegio.backend.domain.service.ICursoService;
import com.ProyectoColegio.backend.domain.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("horarioprofesor")
public class HorarioController {

    @Autowired
    private IHorarioProfesorDAO iHorarioProfesorDAO;

    @Autowired
    private ICursoService iCursoService;

    @Autowired
    private ISalonDAO iSalonDAO;

    @Autowired
    private IProfesorService iProfesorService;

    @GetMapping
    public ResponseEntity<List<HorarioProfesorDTOGet>> gethorariosp(){
        List<HorarioProfesor> horarioProfesor = iHorarioProfesorDAO.findAll();
        List<HorarioProfesorDTOGet> horarioProfesorDTOS = horarioProfesor.stream()
                .map((horario)->{
                    return new HorarioProfesorDTOGet(horario.getProfesor().getId(),horario.getNombreProfesor()
                                ,horario.getDias(),horario.getCurso().getNombre(),
                                horario.getSalon().getNombre(), horario.getHoraInicio(),horario.getHoraFin());
                }).toList();
        return ResponseEntity.ok(horarioProfesorDTOS);
    }

    @PostMapping
    public ResponseEntity<HorarioProfesor> saveProfesor(@RequestBody HorarioProfesorDTO horarioProfesorDTO){
        HorarioProfesor horarioProfesor = new HorarioProfesor();
        Profesor profesor = iProfesorService.findById(horarioProfesorDTO.idProfesor());
        Curso curso = iCursoService.findById(horarioProfesorDTO.idCurso());
        Salon salon = iSalonDAO.findById(horarioProfesorDTO.idSalon()).orElse(null);
        horarioProfesor.setProfesor(profesor);
        horarioProfesor.setNombreProfesor(profesor.getNombre());
        horarioProfesor.setDias(horarioProfesorDTO.dias());
        horarioProfesor.setSalon(salon);
        horarioProfesor.setCurso(curso);
        horarioProfesor.setHoraInicio(horarioProfesorDTO.horainicio());
        horarioProfesor.setHoraFin(horarioProfesorDTO.horafinal());
        iHorarioProfesorDAO.save(horarioProfesor);
        return ResponseEntity.ok(horarioProfesor);
    }
}
