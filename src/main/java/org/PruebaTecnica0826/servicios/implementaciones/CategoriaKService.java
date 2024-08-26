package org.PruebaTecnica0826.servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.PruebaTecnica0826.modelos.CategoriaK;
import org.PruebaTecnica0826.repositorios.ICategoriaKRepository;
import org.PruebaTecnica0826.servicios.interfaces.ICategoriaKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaKService implements ICategoriaKService {

    @Autowired
    private ICategoriaKRepository marcaRepository;

    @Override
    public Page<CategoriaK> buscarTodosPaginados(Pageable pageable) {
        return marcaRepository.findAll(pageable);
    }

    @Override
    public List<CategoriaK> obtenerTodos() {
        return marcaRepository.findAll();
    }

    @Override
    public Optional<CategoriaK> buscarPorId(Long id) {
        return marcaRepository.findById(id);
    }

    @Override
    public CategoriaK crearOEditar(CategoriaK marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public void eliminarPorId(Long id) {
        marcaRepository.deleteById(id);
    }

}
