package co.edu.consultaservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.edu.consultaservice.model.Estudiante;

public interface EstudianteService {

    Estudiante crear(Estudiante e);

    Estudiante obtenerPorId(Long id);

    Page<Estudiante> listar(Pageable pageable);

    Estudiante actualizar(Long id, Estudiante e);

    void eliminar(Long id);
}
