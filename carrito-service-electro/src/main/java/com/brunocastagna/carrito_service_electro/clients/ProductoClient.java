package com.brunocastagna.carrito_service_electro.clients;

import com.brunocastagna.carrito_service_electro.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "producto-service")
public interface ProductoClient {
    @GetMapping("/productos/{id}")
    ProductoDTO traerProducto(@PathVariable("id") Long id);
}
