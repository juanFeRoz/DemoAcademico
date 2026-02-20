package co.edu.demoacademico.controller;

import co.edu.demoacademico.exception.EstudianteNoEncontrado;
import co.edu.demoacademico.exception.EstudianteYaExiste;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = EstudianteNoEncontrado.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody EstudianteNoEncontrado handleEstudianteNoEncontrado(EstudianteNoEncontrado e) {
        return new EstudianteNoEncontrado(e.getMessage());
    }

    @ExceptionHandler(value = EstudianteYaExiste.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public @ResponseBody EstudianteYaExiste handleEstudianteYaExiste(EstudianteYaExiste e) {
        return new EstudianteYaExiste(e.getMessage());
    }
}