package com.ProyectoColegio.backend.Controller;

import com.ProyectoColegio.backend.domain.model.DTO.UsuarioDTO;
import com.ProyectoColegio.backend.domain.model.DTO.UsuarioPostDTO;
import com.ProyectoColegio.backend.domain.model.Rol;
import com.ProyectoColegio.backend.domain.model.Usuario;
import com.ProyectoColegio.backend.domain.service.IRolService;
import com.ProyectoColegio.backend.domain.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/usuario",produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {

    @Autowired
    private IRolService iRolService;

    @Autowired
    private IUsuarioService iUsuarioService;


    @PostMapping
    public ResponseEntity<UsuarioPostDTO> saveUsuario(@RequestBody Usuario usuario){

        usuario.setListaRol(Arrays.asList(iRolService.findById(1L)));
        iUsuarioService.save(usuario);
       return ResponseEntity.ok(new UsuarioPostDTO(usuario.getNombre(), usuario.getCorreo(), usuario.getDni()));
    }





}
