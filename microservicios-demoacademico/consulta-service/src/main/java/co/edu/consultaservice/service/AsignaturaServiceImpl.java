// AsignaturaServiceImpl.java
package co.edu.consultaservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.consultaservice.exception.NotFoundException;
import co.edu.consultaservice.model.Asignatura;
import co.edu.consultaservice.repository.AsignaturaRepository;

import java.util.List;

@Service
@Transactional
public class AsignaturaServiceImpl implements AsignaturaService {

    private final AsignaturaRepository repo;

    public AsignaturaServiceImpl(AsignaturaRepository repo) {
        this.repo = repo;
    }

    @Override
    public Asignatura crear(Asignatura a) {
        return repo.save(a);
    }

    @Override
    @Transactional(readOnly = true)
    public Asignatura obtenerPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Asignatura no encontrada: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Asignatura> listar() {
        return repo.findAll();
    }

    @Override
    public void eliminar(Long id) {
        repo.delete(obtenerPorId(id));
    }
}
