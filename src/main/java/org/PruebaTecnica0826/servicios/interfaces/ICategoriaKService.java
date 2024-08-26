package org.PruebaTecnica0826.servicios.interfaces;

import java.util.List;
import java.util.Optional;

import org.PruebaTecnica0826.modelos.CategoriaK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoriaKService {
    Page<CategoriaK> buscarTodosPaginados(Pageable pageable);

    List<CategoriaK> obtenerTodos();

    Optional<CategoriaK> buscarPorId(Long id);

    CategoriaK crearOEditar(CategoriaK marca);

    void eliminarPorId(Long id);
}
