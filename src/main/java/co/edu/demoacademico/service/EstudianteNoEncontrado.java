package co.edu.demoacademico.service;

public class EstudianteNoEncontrado extends RuntimeException{
   public EstudianteNoEncontrado(String message) {
       super(message);
   }
}
