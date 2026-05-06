// ProgramaService.java
package co.edu.consultaservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.edu.consultaservice.model.Programa;

public interface ProgramaService {
    Programa crear(Programa p);

    Programa obtenerPorId(Long id);

    Page<Programa> listar(Pageable pageable);

    Programa actualizar(Long id, Programa p);

    void eliminar(Long id);
}
