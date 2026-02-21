package co.edu.demoacademico.controller;

import co.edu.demoacademico.service.EmailDuplicadoException;
import co.edu.demoacademico.service.EstudianteNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = EstudianteNoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody EstudianteNoEncontradoException handleEstudianteNoEncontradoException(EstudianteNoEncontradoException e) {
        return new EstudianteNoEncontradoException(e.getMessage());
    }
    @ExceptionHandler(value = EmailDuplicadoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody EmailDuplicadoException handleEmailDuplicadoException(EmailDuplicadoException e) {
        return new EmailDuplicadoException(e.getMessage());
    }
}
