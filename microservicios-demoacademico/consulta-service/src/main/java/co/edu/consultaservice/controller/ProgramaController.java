// ProgramaController.java
package co.edu.consultaservice.controller;

import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.consultaservice.api.ApiResponse;
import co.edu.consultaservice.api.ResponseBuilder;
import co.edu.consultaservice.dto.ProgramaCreateDTO;
import co.edu.consultaservice.dto.ProgramaDTO;
import co.edu.consultaservice.dto.ProgramaUpdateDTO;
import co.edu.consultaservice.handler.ProgramaHandler;

@RestController
@RequestMapping("/api/programas")
public class ProgramaController {

    private final ProgramaHandler handler;

    public ProgramaController(ProgramaHandler handler) {
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProgramaDTO>> crear(@Valid @RequestBody ProgramaCreateDTO in) {
        return ResponseBuilder.created("Programa creado", handler.crear(in));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProgramaDTO>> obtener(@PathVariable Long id) {
        return ResponseBuilder.ok("OK", handler.obtener(id));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<ProgramaDTO>>> listar(@ParameterObject Pageable pageable) {
        return ResponseBuilder.ok("OK", handler.listar(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProgramaDTO>> actualizar(@PathVariable Long id,
            @Valid @RequestBody ProgramaUpdateDTO in) {
        return ResponseBuilder.ok("Programa actualizado", handler.actualizar(id, in));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> eliminar(@PathVariable Long id) {
        handler.eliminar(id);
        return ResponseBuilder.ok("Programa eliminado", null);
    }
}
