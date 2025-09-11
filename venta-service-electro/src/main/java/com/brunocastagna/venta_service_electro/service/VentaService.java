package com.brunocastagna.venta_service_electro.service;

import com.brunocastagna.venta_service_electro.dto.VentaDTO;
import com.brunocastagna.venta_service_electro.model.Venta;

public interface VentaService {

    //Para crear la venta necesito el id del carrito
    Venta crearVenta(Long idCarrito);

    VentaDTO obtenerVenta(Long idVenta);


}
