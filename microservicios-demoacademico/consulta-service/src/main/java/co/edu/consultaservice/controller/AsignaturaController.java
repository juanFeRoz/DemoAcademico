// AsignaturaController.java
package co.edu.consultaservice.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.consultaservice.api.ApiResponse;
import co.edu.consultaservice.api.ResponseBuilder;
import co.edu.consultaservice.dto.AsignaturaCreateDTO;
import co.edu.consultaservice.dto.AsignaturaDTO;
import co.edu.consultaservice.handler.AsignaturaHandler;

import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    private final AsignaturaHandler handler;

    public AsignaturaController(AsignaturaHandler handler) {
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AsignaturaDTO>> crear(@Valid @RequestBody AsignaturaCreateDTO in) {
        return ResponseBuilder.created("Asignatura creada", handler.crear(in));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AsignaturaDTO>>> listar() {
        return ResponseBuilder.ok("OK", handler.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> eliminar(@PathVariable Long id) {
        handler.eliminar(id);
        return ResponseBuilder.ok("Asignatura eliminada", null);
    }
}
