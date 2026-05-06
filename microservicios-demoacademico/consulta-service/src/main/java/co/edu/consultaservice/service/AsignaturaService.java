// AsignaturaService.java
package co.edu.consultaservice.service;

import java.util.List;

import co.edu.consultaservice.model.Asignatura;

public interface AsignaturaService {
    Asignatura crear(Asignatura a);

    Asignatura obtenerPorId(Long id);

    List<Asignatura> listar();

    void eliminar(Long id);
}
