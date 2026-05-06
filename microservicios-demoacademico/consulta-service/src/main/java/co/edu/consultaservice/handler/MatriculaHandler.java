// MatriculaHandler.java
package co.edu.consultaservice.handler;

import org.springframework.stereotype.Component;

import co.edu.consultaservice.dto.MatriculaCreateDTO;
import co.edu.consultaservice.dto.MatriculaDTO;
import co.edu.consultaservice.model.Matricula;
import co.edu.consultaservice.service.MatriculaService;

@Component
public class MatriculaHandler {

    private final MatriculaService service;

    public MatriculaHandler(MatriculaService service) {
        this.service = service;
    }

    public MatriculaDTO matricular(MatriculaCreateDTO in) {
        Matricula m = service.matricular(in.getEstudianteId(), in.getGrupoId());
        return toDto(m);
    }

    private MatriculaDTO toDto(Matricula m) {
        MatriculaDTO dto = new MatriculaDTO();
        dto.setId(m.getId());
        dto.setEstudianteId(m.getEstudiante().getId());
        dto.setEstudianteNombre(m.getEstudiante().getNombre());
        dto.setGrupoId(m.getGrupo().getId());
        dto.setCodigoGrupo(m.getGrupo().getCodigoGrupo());
        dto.setFechaRegistro(m.getFechaRegistro());
        return dto;
    }
}
