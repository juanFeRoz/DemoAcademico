package co.edu.demoacademico.service;

import co.edu.demoacademico.exception.EstudianteNoEncontrado;
import co.edu.demoacademico.exception.EstudianteYaExiste;
import co.edu.demoacademico.model.Estudiante;
import co.edu.demoacademico.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public Estudiante crear(Estudiante estudiante) {

        // ----------------------------
        // ZONA DE LÓGICA DE NEGOCIO:
        // Regla: email único
        // ----------------------------
        repository.findByEmail(estudiante.getEmail()).ifPresent(e -> {
            throw new EstudianteYaExiste("Email ya registrado");
        });

        // ============================
        // ZONA DE ACCESO A LA BD:
        // Persistencia vía Repository
        // ============================
        return repository.save(estudiante);
    }

    public List<Estudiante> listar() {
        // ============================
        // ZONA DE ACCESO A LA BD:
        // Consulta vía Repository
        // ============================
        return repository.findAll();
    }
    public Optional<Estudiante> buscar(String email) throws EstudianteNoEncontrado {
        // ============================
        // ZONA DE ACCESO A LA BD:
        // Consulta vía Repository
        // ============================
        Optional<Estudiante> estudiante = repository.findByEmail(email);
        if (estudiante.isEmpty()) {
            throw new EstudianteNoEncontrado("Estudiante no encontrado");
        }
        return estudiante;
    }
}