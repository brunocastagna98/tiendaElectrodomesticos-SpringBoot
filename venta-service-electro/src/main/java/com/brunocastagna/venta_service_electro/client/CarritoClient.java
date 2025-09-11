package com.brunocastagna.venta_service_electro.client;


import com.brunocastagna.venta_service_electro.dto.CarritoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "carrito-service")
public interface CarritoClient {
    @GetMapping("/carrito/{id}/dto")
    CarritoDTO obtenerCarritoPorId(@PathVariable("id") Long id);
}
