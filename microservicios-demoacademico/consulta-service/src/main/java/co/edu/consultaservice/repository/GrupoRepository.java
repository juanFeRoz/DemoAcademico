// GrupoRepository.java
package co.edu.consultaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.consultaservice.model.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
}
