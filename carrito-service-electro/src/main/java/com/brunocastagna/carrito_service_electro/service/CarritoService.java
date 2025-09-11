package com.brunocastagna.carrito_service_electro.service;

import com.brunocastagna.carrito_service_electro.dto.CarritoDTO;
import com.brunocastagna.carrito_service_electro.model.Carrito;

public interface CarritoService {

    //Crear un carrito
    Carrito crearCarrito( Carrito carrito);
    //Eiminar carrito
    void eliminarCarrito(Long idCarrito);

    //Obtener por DTO
    CarritoDTO obtenerCarritoDTO(Long idCarrito);

    //obtener
    Carrito obtenerCarrito(Long idCarrito);


    //obtener todos los carritos ? mas adelante...

    //Para agregar items
    Carrito agregarItem(Long idCarrito, Long idProducto, int cantidad);

    Carrito quitarItem(Long idCarrito, Long idProducto, int cantidad);

}
