package com.ProyectoColegio.backend.domain.service;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class Errores {
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> NoConectado(DataAccessException ex){
        System.out.println("Error de conexión a la base de datos: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error, no se pudo conectar a la base de datos");
    }
}
