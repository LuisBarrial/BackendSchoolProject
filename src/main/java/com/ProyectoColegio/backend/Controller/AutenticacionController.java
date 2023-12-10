package com.ProyectoColegio.backend.Controller;

import com.ProyectoColegio.backend.domain.model.DTO.LoginDTO;
import com.ProyectoColegio.backend.domain.model.DTO.UsuarioDTO;
import com.ProyectoColegio.backend.domain.model.Usuario;
import com.ProyectoColegio.backend.domain.service.IUsuarioService;
import com.ProyectoColegio.backend.domain.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login",produces = MediaType.APPLICATION_JSON_VALUE)
public class AutenticacionController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<LoginDTO> autenticarUsuario(@RequestBody UsuarioDTO usuarioDTO){

        //  UserDetails usuario =  usuarioService.getUserAndAutorithies(autenticationUserDTO.login());

        Authentication authToken = new UsernamePasswordAuthenticationToken(usuarioDTO.correo()
                ,usuarioDTO.clave());
        System.out.println(authToken + "AuthToken");
        //System.out.println(usuario);

        System.out.println("antes de authmmanager");


        var usuarioAutenticado =authenticationManager.authenticate(authToken);
        System.out.println(usuarioAutenticado + "AuthenticationManager");
        Usuario usuario = (Usuario) usuarioAutenticado.getPrincipal();

        System.out.println("despues de authmmanager");
        System.out.println("despues de authmmanager");
        System.out.println(usuario.getListaRol().get(0).getNombre()+ "usuario");
        var jwtToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        SecurityContextHolder.getContext().setAuthentication(usuarioAutenticado);
        LoginDTO loginDTO = new LoginDTO(jwtToken);
        return ResponseEntity.ok(loginDTO);


    }
}
