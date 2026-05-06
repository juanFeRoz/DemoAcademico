// MatriculaRepository.java
package co.edu.consultaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.consultaservice.model.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    boolean existsByEstudianteIdAndGrupoId(Long estudianteId, Long grupoId);

    long countByGrupoId(Long grupoId);
}
