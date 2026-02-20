package co.edu.demoacademico.exception;

public class EstudianteYaExiste extends RuntimeException {
    public EstudianteYaExiste(String message) {
        super(message);
    }
}
