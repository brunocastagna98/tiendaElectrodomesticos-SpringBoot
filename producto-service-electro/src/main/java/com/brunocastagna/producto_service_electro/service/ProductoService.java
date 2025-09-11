package com.brunocastagna.producto_service_electro.service;

import com.brunocastagna.producto_service_electro.model.Producto;

import java.util.List;

public interface ProductoService {

    //CRUD

    Producto crearProducto(Producto producto);
    Producto traerProducto(Long idProducto);
    List<Producto> traerTodos();
    Producto editarProducto( Long idProducto, Producto produEditado);
    void eliminarProducto(Long idProducto);

}
