// ProgramaRepository.java
package co.edu.consultaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.consultaservice.model.Programa;

public interface ProgramaRepository extends JpaRepository<Programa, Long> {
    boolean existsByCodigo(String codigo);
}
