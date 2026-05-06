// GrupoController.java
package co.edu.consultaservice.controller;

import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.consultaservice.api.ApiResponse;
import co.edu.consultaservice.api.ResponseBuilder;
import co.edu.consultaservice.dto.GrupoCreateDTO;
import co.edu.consultaservice.dto.GrupoDTO;
import co.edu.consultaservice.handler.GrupoHandler;

@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

    private final GrupoHandler handler;

    public GrupoController(GrupoHandler handler) {
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<GrupoDTO>> crear(@Valid @RequestBody GrupoCreateDTO in) {
        return ResponseBuilder.created("Grupo creado", handler.crear(in));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<GrupoDTO>>> listar(@ParameterObject Pageable pageable) {
        return ResponseBuilder.ok("OK", handler.listar(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> eliminar(@PathVariable Long id) {
        handler.eliminar(id);
        return ResponseBuilder.ok("Grupo eliminado", null);
    }
}
