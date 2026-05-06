// MatriculaService.java
package co.edu.consultaservice.service;

import co.edu.consultaservice.model.Matricula;

public interface MatriculaService {
    Matricula matricular(Long estudianteId, Long grupoId);
}
