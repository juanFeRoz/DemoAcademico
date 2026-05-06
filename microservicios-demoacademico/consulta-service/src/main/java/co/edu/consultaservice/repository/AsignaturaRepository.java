// AsignaturaRepository.java
package co.edu.consultaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.consultaservice.model.Asignatura;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
}
