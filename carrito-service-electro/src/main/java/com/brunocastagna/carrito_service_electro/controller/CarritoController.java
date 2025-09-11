package com.brunocastagna.carrito_service_electro.controller;


import com.brunocastagna.carrito_service_electro.dto.CarritoDTO;
import com.brunocastagna.carrito_service_electro.model.Carrito;
import com.brunocastagna.carrito_service_electro.service.CarritoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    private final CarritoService carriServ;


    public CarritoController(CarritoService carriServ) {
        this.carriServ = carriServ;
    }

    //crear carrito nuevo
    @PostMapping("/crear")
    public Carrito crearCarrito(@RequestBody Carrito carrito){
        return carriServ.crearCarrito(carrito);
    }

    // obtener carrito como DTO
    @GetMapping("/{id}/dto")
    public CarritoDTO obtenerCarritoDTO(@PathVariable Long id) {
        return carriServ.obtenerCarritoDTO(id);
    }



    //obtener carrito por id
    @GetMapping("/{id}")
    public Carrito obtenerCarritoPorId( @PathVariable Long id){
        return carriServ.obtenerCarrito(id);
    }

    //borrar carrito
    @DeleteMapping("/borrar/{id}")
    public void borrarCarritoPorId( @PathVariable Long id){
        carriServ.eliminarCarrito(id);
    }

    @PostMapping("/{idCarrito}/agregar/{idProducto}")
    public Carrito agregarItem(
            @PathVariable Long idCarrito,
            @PathVariable Long idProducto,
            @RequestParam int cantidad) {
        return carriServ.agregarItem(idCarrito, idProducto, cantidad);
    }
}
