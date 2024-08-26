package org.PruebaTecnica0826.servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.PruebaTecnica0826.modelos.ProductoK;
import org.PruebaTecnica0826.repositorios.IProductoKRepository;
import org.PruebaTecnica0826.servicios.interfaces.IProductoKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProductoKService implements IProductoKService {


    
    @Autowired
    private IProductoKRepository productoRepository;
    @Override
    public Page<ProductoK> buscarTodosPaginados(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodosPaginados'");
    }

    @Override
    public List<ProductoK> obtenerTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTodos'");
    }

    @Override
    public Optional<ProductoK> buscarPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public ProductoK crearOEditar(ProductoK marca) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearOEditar'");
    }

    @Override
    public void eliminarPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarPorId'");
    }

}
