package co.edu.consultaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.consultaservice.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Long id);
}
