package com.brunocastagna.venta_service_electro.service;


import com.brunocastagna.venta_service_electro.client.CarritoClient;
import com.brunocastagna.venta_service_electro.dto.CarritoDTO;
import com.brunocastagna.venta_service_electro.dto.VentaDTO;
import com.brunocastagna.venta_service_electro.model.Venta;
import com.brunocastagna.venta_service_electro.repository.VentaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VentaServiceImpl implements VentaService{


    private final VentaRepository ventaRepo;
    private final CarritoClient carritoClient;

    public VentaServiceImpl(VentaRepository ventaRepo, CarritoClient carritoClient) {
        this.ventaRepo = ventaRepo;
        this.carritoClient = carritoClient;
    }


    @Override
    public Venta crearVenta(Long idCarrito) {

        Venta ventaCreada = new Venta();
        //asocio venta creada con el carrito
        ventaCreada.setIdCarrito(idCarrito);
        //asocio la fecha
        ventaCreada.setFechaVenta(LocalDate.now());
        //obtengo el total
        ventaCreada.setMontoTotal(carritoClient.obtenerCarritoPorId(idCarrito).getTotal());

        //una vez guardado los campos ahi recien hago el save
        return ventaRepo.save(ventaCreada);
    }

    @Override
    public VentaDTO obtenerVenta(Long idVenta) {


        //Busco la venta en la BD

        Venta venta = ventaRepo.findById(idVenta).
                orElseThrow(()-> new RuntimeException("Venta no encontrada!"));


        //Seteo lo de ventas en el ventaDTO
        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setIdVenta(venta.getIdVenta());
        ventaDTO.setFechaVenta(venta.getFechaVenta());
        ventaDTO.setMontoTotal(venta.getMontoTotal());
        ventaDTO.setIdCarrito(venta.getIdCarrito());

        //ahora consulto el carrito para traer los productos
        CarritoDTO carrito = carritoClient.obtenerCarritoPorId(venta.getIdCarrito());
        ventaDTO.setListaProductos(carrito.getListaProducto());

        return  ventaDTO;
    }
}
