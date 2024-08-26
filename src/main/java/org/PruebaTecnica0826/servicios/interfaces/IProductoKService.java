package org.PruebaTecnica0826.servicios.interfaces;

import java.util.List;
import java.util.Optional;
import org.PruebaTecnica0826.modelos.ProductoK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductoKService {
    Page<ProductoK> buscarTodosPaginados(Pageable pageable);

    List<ProductoK> obtenerTodos();

    Optional<ProductoK> buscarPorId(Integer id);

    ProductoK crearOEditar(ProductoK marca);

    void eliminarPorId(Integer id);
}
