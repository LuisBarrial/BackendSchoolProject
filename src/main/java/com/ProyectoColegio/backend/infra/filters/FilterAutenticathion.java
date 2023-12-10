package com.ProyectoColegio.backend.infra.filters;

import com.ProyectoColegio.backend.domain.repo.IUsuarioDAO;
import com.ProyectoColegio.backend.domain.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class FilterAutenticathion extends OncePerRequestFilter  {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private IUsuarioDAO usuarioDAO;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    var tokenJWT = recuperarToken(request);

    if(tokenJWT!=null){

        var subject = tokenService.getSubject(tokenJWT);

        if(subject!=null){


            var usuario = usuarioDAO.findByCorreo(subject);
            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }


    }

        filterChain.doFilter(request,response);

    }

    private String recuperarToken(HttpServletRequest request){
        var authorizationHeader = request.getHeader("Authorization");
        if(authorizationHeader!=null){
            int startIndex = "Bearer ".length();
            if(authorizationHeader.length() > startIndex){
                return authorizationHeader.substring(startIndex);
            }
        }
        return null;
    }
}
