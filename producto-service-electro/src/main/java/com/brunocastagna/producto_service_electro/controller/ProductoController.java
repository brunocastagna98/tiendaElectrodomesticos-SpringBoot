package com.brunocastagna.producto_service_electro.controller;

import com.brunocastagna.producto_service_electro.dto.ProductoDTO;
import com.brunocastagna.producto_service_electro.model.Producto;
import com.brunocastagna.producto_service_electro.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService produServ;

    public ProductoController(ProductoService produServ) {
        this.produServ = produServ;
    }

    // Crear producto (devuelvo DTO para mantener consistencia)
    @PostMapping("/crear")
    public ProductoDTO crearProducto(@RequestBody Producto producto){
        Producto p = produServ.crearProducto(producto);
        return new ProductoDTO(p);
    }

    // Traer producto por id
    @GetMapping("/{id}")
    public ProductoDTO traerProducto(@PathVariable Long id) {
        Producto p = produServ.traerProducto(id);
        return new ProductoDTO(p);
    }

    // Listar todos los productos como DTO
    @GetMapping("/todos")
    public List<ProductoDTO> listaProductos(){
        return produServ.traerTodos()
                .stream()
                .map(ProductoDTO::new)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarProducto(@PathVariable Long id){
        produServ.eliminarProducto(id);
    }

    @PutMapping("/editar/{id}")
    public ProductoDTO editarProducto(@PathVariable Long id, @RequestBody Producto productoEditado){
        Producto p = produServ.editarProducto(id, productoEditado);
        return new ProductoDTO(p);
    }
}
