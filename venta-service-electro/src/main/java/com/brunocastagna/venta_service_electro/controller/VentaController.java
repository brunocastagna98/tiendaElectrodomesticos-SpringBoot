package com.brunocastagna.venta_service_electro.controller;

import com.brunocastagna.venta_service_electro.client.CarritoClient;
import com.brunocastagna.venta_service_electro.dto.VentaDTO;
import com.brunocastagna.venta_service_electro.model.Venta;
import com.brunocastagna.venta_service_electro.service.VentaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venta")
public class VentaController {

    private final VentaService ventaServ;

    public VentaController(VentaService ventaServ) {
        this.ventaServ = ventaServ;
    }

    //Crear venta
    @PostMapping("/crear")
    Venta crearVenta(@RequestParam Long idCarrito){
        return ventaServ.crearVenta(idCarrito);
    }


    //Obtener venta
    @GetMapping("/{idVenta}")
    VentaDTO obtenerVenta(@PathVariable Long idVenta){
        return ventaServ.obtenerVenta(idVenta);
    }


}
