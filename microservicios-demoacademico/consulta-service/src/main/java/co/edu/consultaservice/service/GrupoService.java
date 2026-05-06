// GrupoService.java
package co.edu.consultaservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.edu.consultaservice.model.Grupo;

public interface GrupoService {
    Grupo crear(Grupo g);

    Grupo obtenerPorId(Long id);

    Page<Grupo> listar(Pageable pageable);

    void eliminar(Long id);
}
