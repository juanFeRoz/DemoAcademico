package co.edu.demoacademico.controller;

import co.edu.demoacademico.service.EstudianteNoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = EstudianteNoEncontrado.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody EstudianteNoEncontrado handleEstudianteNoEncontradoException(EstudianteNoEncontrado e) {
        return new EstudianteNoEncontrado(e.getMessage());
    }
}
